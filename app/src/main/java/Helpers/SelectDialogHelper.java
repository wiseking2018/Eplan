package Helpers;

import android.content.Context;
import android.text.InputType;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import wang.wiseking.eplan.R;

public class SelectDialogHelper{
    private int mCurrentDialogStyle = R.style.QMUI_Dialog;

    public void showMessagePositiveDialog(Context mContext,String msg) {
        new QMUIDialog.MessageDialogBuilder(mContext)
                .setTitle("标题")
                .setMessage("确定要发送吗？")
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("确定", (dialog, index) -> {
                    dialog.dismiss();
                    Toast.makeText(mContext, "发送成功", Toast.LENGTH_SHORT).show();
                })
                .create(mCurrentDialogStyle).show();
    }

    private void showMessageNegativeDialog(Context mContext) {
        new QMUIDialog.MessageDialogBuilder(mContext)
                .setTitle("标题")
                .setMessage("确定要删除吗？")
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction(0, "删除", QMUIDialogAction.ACTION_PROP_NEGATIVE, (dialog, index) -> {
                    Toast.makeText(mContext, "删除成功", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .create(mCurrentDialogStyle).show();
    }

    private void showLongMessageDialog(Context mContext) {
        new QMUIDialog.MessageDialogBuilder(mContext)
                .setTitle("标题")
                .setMessage("这是一段很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很" +
                        "长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长" +
                        "很长很长很长很长很长很长很长很长很长很长很长很长很长很长长很长的文案")
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .create(mCurrentDialogStyle).show();
    }

    private void showConfirmMessageDialog(Context mContext) {
        new QMUIDialog.CheckBoxMessageDialogBuilder(mContext)
                .setTitle("退出后是否删除账号信息?")
                .setMessage("删除账号信息")
                .setChecked(true)
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("退出", (dialog, index) -> dialog.dismiss())
                .create(mCurrentDialogStyle).show();
    }

    private void showMenuDialog(Context mContext) {
        final String[] items = new String[]{"选项1", "选项2", "选项3"};
        new QMUIDialog.MenuDialogBuilder(mContext)
                .addItems(items, (dialog, which) -> {
                    Toast.makeText(mContext, "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .create(mCurrentDialogStyle).show();
    }

    private void showSingleChoiceDialog(Context mContext) {
        final String[] items = new String[]{"选项1", "选项2", "选项3"};
        final int checkedIndex = 1;
        new QMUIDialog.CheckableDialogBuilder(mContext)
                .setCheckedIndex(checkedIndex)
                .addItems(items, (dialog, which) -> {
                    Toast.makeText(mContext, "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .create(mCurrentDialogStyle).show();
    }

    private void showMultiChoiceDialog(Context mContext) {
        final String[] items = new String[]{"选项1", "选项2", "选项3", "选项4", "选项5", "选项6"};
        final QMUIDialog.MultiCheckableDialogBuilder builder = new QMUIDialog.MultiCheckableDialogBuilder(mContext)
                .setCheckedItems(new int[]{1, 3})
                .addItems(items, (dialog, which) -> {
                });
        builder.addAction("取消", (dialog, index) -> dialog.dismiss());
        builder.addAction("提交", (dialog, index) -> {
            StringBuilder result = new StringBuilder("你选择了 ");
            for (int i = 0; i < builder.getCheckedItemIndexes().length; i++) {
                result.append("").append(builder.getCheckedItemIndexes()[i]).append("; ");
            }
            Toast.makeText(mContext, result.toString(), Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.create(mCurrentDialogStyle).show();
    }

    private void showNumerousMultiChoiceDialog(Context mContext) {
        final String[] items = new String[]{
                "选项1", "选项2", "选项3", "选项4", "选项5", "选项6",
                "选项7", "选项8", "选项9", "选项10", "选项11", "选项12",
                "选项13", "选项14", "选项15", "选项16", "选项17", "选项18"
        };
        final QMUIDialog.MultiCheckableDialogBuilder builder = new QMUIDialog.MultiCheckableDialogBuilder(mContext)
                .setCheckedItems(new int[]{1, 3})
                .addItems(items, (dialog, which) -> {
                });
        builder.addAction("取消", (dialog, index) -> dialog.dismiss());
        builder.addAction("提交", (dialog, index) -> {
            StringBuilder result = new StringBuilder("你选择了 ");
            for (int i = 0; i < builder.getCheckedItemIndexes().length; i++) {
                result.append("").append(builder.getCheckedItemIndexes()[i]).append("; ");
            }
            Toast.makeText(mContext, result.toString(), Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.create(mCurrentDialogStyle).show();
    }

    private void showEditTextDialog(Context mContext) {
        final QMUIDialog.EditTextDialogBuilder builder = new QMUIDialog.EditTextDialogBuilder(mContext);
        builder.setTitle("标题")
                .setPlaceholder("在此输入您的昵称")
                .setInputType(InputType.TYPE_CLASS_TEXT)
                .addAction("取消", (dialog, index) -> dialog.dismiss())
                .addAction("确定", (dialog, index) -> {
                    CharSequence text = builder.getEditText().getText();
                    if (text != null && text.length() > 0) {
                        Toast.makeText(mContext, "您的昵称: " + text, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(mContext, "请填入昵称", Toast.LENGTH_SHORT).show();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }

    private void showSimpleBottomSheetGrid(Context mContext) {
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        final int TAG_SHARE_WEIBO = 2;
        final int TAG_SHARE_CHAT = 3;
        final int TAG_SHARE_LOCAL = 4;
        new QMUIBottomSheet.BottomGridSheetBuilder(mContext)
                .addItem(R.mipmap.ic_launcher, "分享到微信", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "分享到微博", TAG_SHARE_WEIBO, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "分享到私信", TAG_SHARE_CHAT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "保存到本地", TAG_SHARE_LOCAL, QMUIBottomSheet.BottomGridSheetBuilder.SECOND_LINE)
                .setOnSheetItemClickListener((dialog, itemView) -> {
                    dialog.dismiss();
                    int tag = (int) itemView.getTag();
                    switch (tag) {
                        case TAG_SHARE_WECHAT_FRIEND:
                            Toast.makeText(mContext, "分享到微信", Toast.LENGTH_SHORT).show();
                            break;
                        case TAG_SHARE_WECHAT_MOMENT:
                            Toast.makeText(mContext, "分享到朋友圈", Toast.LENGTH_SHORT).show();
                            break;
                        case TAG_SHARE_WEIBO:
                            Toast.makeText(mContext, "分享到微博", Toast.LENGTH_SHORT).show();
                            break;
                        case TAG_SHARE_CHAT:
                            Toast.makeText(mContext, "分享到私信", Toast.LENGTH_SHORT).show();
                            break;
                        case TAG_SHARE_LOCAL:
                            Toast.makeText(mContext, "保存到本地", Toast.LENGTH_SHORT).show();
                            break;
                    }
                })
                .build().show();
    }
}
