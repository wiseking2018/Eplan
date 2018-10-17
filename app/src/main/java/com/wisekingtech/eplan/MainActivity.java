package com.wisekingtech.eplan;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.wisekingtech.eplan.Fragments.About1Fragment;
import com.wisekingtech.eplan.Fragments.AboutFragment;
import com.wisekingtech.eplan.Fragments.BlankFragment;
import com.wisekingtech.eplan.Fragments.HomeFragment;
import com.wisekingtech.eplan.base.BaseFragment;
import com.wisekingtech.eplan.base.BaseFragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;


public class MainActivity extends BaseFragmentActivity {

    private QMUITabSegment mTabSegment;
    private ViewPager mContentViewPager;
    private Context context;
    private HomeFragment homeFragment;
    QMUITopBarLayout mTopBar;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = MainActivity.this;
        setContentView(R.layout.activity_main);
        mTopBar = findViewById(R.id.main_topbar);
        mTopBar.setTitle("首页管理系统222");
        mTopBar.addRightImageButton(R.drawable.qmui_icon_tip_new,R.id.main_topbar)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("tag","点击QQ");
                    }
                });
        mTabSegment = findViewById(R.id.tabSegment);
        mContentViewPager = findViewById(R.id.contentViewPager);
       settabs();
    }

    private void showDialog() {
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("QMUI对话框标题")
                .setMessage("这是QMUI框架对话框的内容")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT)
                                .show();                     }                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .show();
    }
    private void setTopbar() {
//        topbar.setTitle("首页");
//        topbar.addLeftTextButton("返回",R.id.button2)
//                .setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //LogUtil.d("点击返回");
//                    }
//                });
//        topbar.addRightImageButton(R.drawable.qmui_icon_tip_new,R.id.button2)
//                .setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                       // LogUtil.d("点击QQ");
//                    }
//                });
//        View root = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
//        RelativeLayout.LayoutParams layoutParams = topbar.generateTopBarImageButtonLayoutParams();
//        //topbar.addRightView(root,R.id.qmui_icon_tip_new,layoutParams);
//        root.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //LogUtil.d("点击分享");
//            }
//        });
    }
    private void initTopBar() {
        mTopBar.setBackgroundColor(ContextCompat.getColor(this, R.color.app_color_theme_4));
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        mTopBar.setTitle("沉浸式状态栏示例");

    }
    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(context, R.attr.qmui_config_color_gray_6);
        int selectColor = QMUIResHelper.getAttrColor(context, R.attr.qmui_config_color_blue);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(selectColor);
        mTabSegment.setDefaultTabIconPosition(QMUITabSegment.ICON_POSITION_BOTTOM);

//        // 如果你的 icon 显示大小和实际大小不吻合:
//        // 1. 设置icon 的 bounds
//        // 2. Tab 使用拥有5个参数的构造器
//        // 3. 最后一个参数（setIntrinsicSize）设置为false
//        int iconShowSize = QMUIDisplayHelper.dp2px(getContext(), 20);
//        Drawable normalDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_component);
//        normalDrawable.setBounds(0, 0, iconShowSize, iconShowSize);
//        Drawable selectDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_component_selected);
//
//        selectDrawable.setBounds(0, 0, iconShowSize, iconShowSize);
//
//        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
//                normalDrawable,
//                normalDrawable,
//                "Components", false, false
//        );

        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_component),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_component_selected),
                "Components", false
        );

        QMUITabSegment.Tab util = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_util),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_util_selected),
                "Helper", false
        );
        QMUITabSegment.Tab lab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab_selected),
                "Lab", false
        );
        mTabSegment.addTab(component)
                .addTab(util)
                .addTab(lab);
        mTabSegment.setHasIndicator(true);
        mTabSegment.setMode(QMUITabSegment.MODE_SCROLLABLE);
        mTabSegment.setupWithViewPager(mContentViewPager, false);
    }

    private void initTabAndPager() {
        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_component),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_component_selected),
                "Components", false
        );

        QMUITabSegment.Tab util = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_util),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_util_selected),
                "Helper", false
        );
        QMUITabSegment.Tab lab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab_selected),
                "Lab", false
        );
        mTabSegment.addTab(component)
                .addTab(util)
                .addTab(lab);
        mContentViewPager.setAdapter(mPagerAdapter);
        mContentViewPager.setCurrentItem(mDestPage.getPosition(), false);
        for (int i = 0; i < 10; i++) {
//            mTabSegment.addTab(new QMUITabSegment.Tab("Item " + (i + 1)));
        }
        int space = QMUIDisplayHelper.dp2px(context, 16);
        mTabSegment.setHasIndicator(true);
        mTabSegment.setMode(QMUITabSegment.MODE_SCROLLABLE);
        mTabSegment.setItemSpaceInScrollMode(space);
        mTabSegment.setupWithViewPager(mContentViewPager, false);
        mTabSegment.setPadding(space, 0, space, 0);
    }

    @Override
    protected int getContextViewId() {
        return R.id.main_container;
    }

    private Map<ContentPage, View> mPageMap = new HashMap<>();
    private ContentPage mDestPage = ContentPage.Item1;
    private PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return ContentPage.SIZE;
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            ContentPage page = ContentPage.getPage(position);
            View view = getPageView(page);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            container.addView(view, params);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    };
    private View getPageView(ContentPage page) {
        View view = mPageMap.get(page);
        if (view == null) {
            TextView textView = new TextView(context);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            textView.setTextColor(ContextCompat.getColor(context, R.color.app_color_description));
            textView.setText("这是第 " + (page.getPosition() + 1) + " 个 Item 的内容区");
            view = textView;
            mPageMap.put(page, view);
        }
        return view;
    }

    public enum ContentPage {
        Item1(0),
        Item2(1),
        Item3(2),
        Item4(3),
        Item5(4),
        Item6(5),
        Item7(6),
        Item8(7),
        Item9(8),
        Item10(9);
        public static final int SIZE = 10;
        private final int position;

        ContentPage(int pos) {
            position = pos;
        }

        public static ContentPage getPage(int position) {
            switch (position) {
                case 0:
                    return Item1;
                case 1:
                    return Item2;
                case 2:
                    return Item3;
                case 3:
                    return Item4;
                case 4:
                    return Item5;
                case 5:
                    return Item6;
                case 6:
                    return Item7;
                case 7:
                    return Item8;
                case 8:
                    return Item9;
                case 9:
                    return Item10;
                default:
                    return Item1;
            }
        }

        public int getPosition() {
            return position;
        }
    }
    private void settabs() {
        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_component),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_component_selected),
                "Components", false
        );

        QMUITabSegment.Tab util = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_util),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_util_selected),
                "Helper", false
        );
        QMUITabSegment.Tab lab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab),
                ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab_selected),
                "Lab", false
        );
        List<Fragment> fragments= new ArrayList<>();
        AboutFragment mFirstFragment = new AboutFragment();
        About1Fragment  mSecondFragment = new About1Fragment();
        fragments.add(mFirstFragment);
        fragments.add(mSecondFragment);
        BlankFragment mThirdFragment = new BlankFragment();
        fragments.add(mThirdFragment);
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mContentViewPager.setAdapter(adapter);
        for (int i = 0; i <fragments.size(); i++) {
            QMUITabSegment.Tab lab_temp = new QMUITabSegment.Tab(
                    ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab),
                    ContextCompat.getDrawable(context, R.mipmap.icon_tabbar_lab_selected),
                    "Lab" + (i + 1), false
            );
            mTabSegment.addTab(lab_temp);
        }
        int space = QMUIDisplayHelper.dp2px(context, 16);
        mTabSegment.setHasIndicator(true);
        mTabSegment.setMode(QMUITabSegment.MODE_FIXED);
        //MODE_SCROLLABLE 自适应宽度+滚动   MODE_FIXED  均分
        mTabSegment.setItemSpaceInScrollMode(space);
        mTabSegment.setPadding(space, 0, space, 0);
        mTabSegment.setDefaultTabIconPosition(QMUITabSegment.ICON_POSITION_TOP);
        mTabSegment.setupWithViewPager(mContentViewPager, false);

    }
}
