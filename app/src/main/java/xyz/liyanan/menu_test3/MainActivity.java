package xyz.liyanan.menu_test3;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //普通菜单
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //获取MenuInflater
//        MenuInflater inflater=getMenuInflater();
//        //加载menu资源
//        inflater.inflate(R.menu.oridinary,menu);
//        //返回值必须为true，不然菜单无法显示
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.option1:
//                return true;
//            case R.id.option2:
//                return true;
//            case R.id.option3:
//                return true;
//            case R.id.option4:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


    //多级菜单
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //获取MenuInflater
//        MenuInflater inflater = getMenuInflater();
//        //加载menu资源
//        inflater.inflate(R.menu.multi, menu);
//        //返回值必须为true，不然菜单无法显示
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.files:
//                return true;
//            case R.id.new_file:
//                return true;
//            case R.id.file_save:
//                return true;
//            case R.id.file_more:
//                return true;
//            case R.id.file_help:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    //上一步下一步的实现在运行时修改选项菜单
    private boolean isShowNext = true;//当前是否显示【下一步】

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.modify,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        if(isShowNext){//根据标识判断当前应该启用哪一个菜单
            menu.findItem(R.id.latter).setEnabled(true);
            menu.findItem(R.id.former).setEnabled(false);
        }else {
            menu.findItem(R.id.former).setEnabled(true);
            menu.findItem(R.id.latter).setEnabled(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.latter:
                isShowNext = false;
                invalidateOptionsMenu();//通知系统刷新menu
                return true;
            case R.id.former:
                isShowNext = true;
                invalidateOptionsMenu();//通知系统刷新menu
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
