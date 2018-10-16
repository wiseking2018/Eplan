package Helpers;

import android.content.Context;
import android.os.Handler;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

/*
根据所选参数显示一个信息提示框
 */
public class TipDialogHelper {
//    int iconType = QMUITipDialog.Builder.ICON_TYPE_LOADING;
    private void showLoadingDialog(Context mContext,int iconType, String msg) {
        final QMUITipDialog tipDialog;
        if (iconType < 0 || iconType > 4) {
            iconType = 0;
        }
        if (msg == null || msg.equals("")) {
            msg = "正在加载";
        }
        tipDialog = new QMUITipDialog.Builder(mContext)
                .setIconType(iconType)
                .setTipWord(msg)
                .create();
        tipDialog.show();
        //new Handler().postDelayed(tipDialog::dismiss, 1500);
    }
}
