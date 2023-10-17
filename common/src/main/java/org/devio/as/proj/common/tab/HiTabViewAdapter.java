package org.devio.as.proj.common.tab;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.devio.hi.ui.tab.bottom.HiTabBottomInfo;

import java.util.List;

/**
 * 通过添加适配器的方式，来对HiFragmentTabView的相关逻辑操作进行解耦
 * 
 */
public class HiTabViewAdapter {

    private List<HiTabBottomInfo<?>> mInfoList;
    private Fragment mCurFragment;
    private FragmentManager mFragmentManager;

    public HiTabViewAdapter(FragmentManager fragmentManager, List<HiTabBottomInfo<?>> infoList) {
        this.mFragmentManager = fragmentManager;
        this.mInfoList = infoList;
    }

    /**
     * 实例化以及显示指定位置的Fragment
     */
    public void instantiateItem(View container, int position) {
        //打开下一个Fragment的时候，需要将当前Fragment隐藏
        FragmentTransaction mCurTransaction = mFragmentManager.beginTransaction();
        if (mCurFragment != null) {
            mCurTransaction.hide(mCurFragment);
        }

        //创建Fragment的唯一TAG
        String name = container.getId() + ":" + position;
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            //如果在Manager里面已经创建了Fragment，则直接用Transaction将它显示出来
            mCurTransaction.show(fragment);
        } else {
            //如果之前没有创建，则创建Fragment的实例
            fragment = getItem(position);
            //如果该Fragment还未添加，则将它添加到Transaction中
            if (!fragment.isAdded()) {
                mCurTransaction.add(container.getId(), fragment, name);
            }
        }
        //将Fragment赋值给当前Fragment，并提交这次修改
        mCurFragment = fragment;
        mCurTransaction.commitNowAllowingStateLoss();
    }

    public Fragment getCurrentFragment() {
        return mCurFragment;
    }

    public Fragment getItem(int position) {
        try {
            return (Fragment) mInfoList.get(position).fragment.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCount() {
        return mInfoList == null ? 0 : mInfoList.size();
    }

}
