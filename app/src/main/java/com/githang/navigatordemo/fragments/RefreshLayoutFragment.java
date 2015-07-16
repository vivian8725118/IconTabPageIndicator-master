package com.githang.navigatordemo.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githang.navigatordemo.Book;
import com.githang.navigatordemo.R;
import com.githang.navigatordemo.adapter.BooksAdapter;
import com.githang.navigatordemo.adapter.BooksDataSource;

import java.util.List;

import mvc.MVCHelper;
import mvc.MVCSwipeRefreshHelper;


public class RefreshLayoutFragment extends BaseFragment {
    private MVCHelper<List<Book>> listViewHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflater == null) {
            inflater = LayoutInflater.from(getActivity());
        }
        View view = inflater.inflate(R.layout.fragment_swiperefresh, null);
        // 设置LoadView的factory，用于创建使用者自定义的加载失败，加载中，加载更多等布局,写法参照DeFaultLoadViewFactory
//        ListViewHelper.setLoadViewFactory(new LoadViewFactory());

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        listViewHelper = new MVCSwipeRefreshHelper<List<Book>>(swipeRefreshLayout);

        // 设置数据源
        listViewHelper.setDataSource(new BooksDataSource());
        // 设置适配器
        listViewHelper.setAdapter(new BooksAdapter(getActivity()));

        // 加载数据
        listViewHelper.refresh();
        return view;
    }


}
