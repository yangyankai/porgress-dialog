package com.example.ykai.test;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 方式一：new Dialog
//        final ProgressDialog dialog = new ProgressDialog(this);
//        dialog.show();
//        dialog.dismiss();

        // 方式二：使用静态方式创建并显示，这种进度条只能是圆形条,设置title和Message提示内容
//        ProgressDialog dialog2 = ProgressDialog.show(this, "提示", "正在登陆中");

        // 方式三 使用静态方式创建并显示，这种进度条只能是圆形条,这里最后一个参数boolean indeterminate设置是否是不明确的状态
//        ProgressDialog dialog3 = ProgressDialog.show(this, "提示", "正在登陆中", false);

        // 方式四 使用静态方式创建并显示，这种进度条只能是圆形条,这里最后一个参数boolean cancelable 设置是否进度条是可以取消的
//        ProgressDialog dialog4 = ProgressDialog.show(this, "提示", "正在登陆中", false, true);

        // 方式五 使用静态方式创建并显示，这种进度条只能是圆形条,这里最后一个参数 DialogInterface.OnCancelListener
        // cancelListener用于监听进度条被取消
//        ProgressDialog dialog5 = ProgressDialog.show(this, "提示", "正在登陆中", true, true, cancelListener);
/**
 * ProgressDialog的样式有两种，一种是圆形不明确状态，一种是水平进度条状态  第一种方式：圆形进度条
 */
//方式六 自定义进度条
//        final ProgressDialog dialog = new ProgressDialog(this);
//        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
//        dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
//        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
////        dialog.setIcon(R.mipmap.ic_launcher);//
//        // 设置提示的title的图标，默认是没有的，如果没有设置title的话只设置Icon是不会显示图标的
////        dialog.setTitle("提示");
//        // dismiss监听
//        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//        // 监听Key事件被传递给dialog
//        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
//
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode,
//                                 KeyEvent event) {
//                // TODO Auto-generated method stub
//                return false;
//            }
//        });
//        // 监听cancel事件
//        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//        //设置可点击的按钮，最多有三个(默认情况下)
////        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
////                new DialogInterface.OnClickListener() {
////
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        // TODO Auto-generated method stub
////
////                    }
////                });
////        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
////                new DialogInterface.OnClickListener() {
////
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        // TODO Auto-generated method stub
////
////                    }
////                });
////        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "中立",
////                new DialogInterface.OnClickListener() {
////
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        // TODO Auto-generated method stub
////
////                    }
////                });
//        dialog.setMessage("这是一个圆形进度条");
//        dialog.show();
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                try {
//                    Thread.sleep(5000);
//                    // cancel和dismiss方法本质都是一样的，都是从屏幕中删除Dialog,唯一的区别是
//                    // 调用cancel方法会回调DialogInterface.OnCancelListener如果注册的话,dismiss方法不会回掉
//                    dialog.cancel();
//                    // dialog.dismiss();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();

//        方式 7
        // 进度条还有二级进度条的那种形式，这里就不演示了
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
        dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        dialog.setIcon(R.mipmap.ic_launcher);// 设置提示的title的图标，默认是没有的
        dialog.setTitle("提示");
        dialog.setMax(100);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                });
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                });
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "中立",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                });
        dialog.setMessage("这是一个水平进度条");
        dialog.show();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(200);
                        // 更新进度条的进度,可以在子线程中更新进度条进度
                        dialog.incrementProgressBy(1);
                        // dialog.incrementSecondaryProgressBy(10)//二级进度条更新方式
                        i++;

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                // 在进度条走完时删除Dialog
                dialog.dismiss();

            }
        }).start();
    }

//   方式 5中的取消监听
    private DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {

        @Override
        public void onCancel(DialogInterface dialog) {
            // TODO Auto-generated method stub
            Toast.makeText(MainActivity.this, "进度条被取消", Toast.LENGTH_LONG).show();

        }
    };

}
