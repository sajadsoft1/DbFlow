package xyz.regin.dbflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import xyz.regin.dbflow.bean.ContentBean;
import xyz.regin.dbflow.db.MyDatabase;
import xyz.regin.dbflow.source.SourceList;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 *
 * @author Reginer in  2016/12/12 15:36.
 *         Description:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Reginer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button mButton = (Button) findViewById(R.id.button);
        Button mButton2 = (Button) findViewById(R.id.button2);
        Button mButton3 = (Button) findViewById(R.id.button3);
        Button mButton4 = (Button) findViewById(R.id.button4);

        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                saveSingle();
                break;
            case R.id.button2:
                saveList();
                break;
            case R.id.button3:
                readSingle();
                break;
            case R.id.button4:
                readList();
                break;
        }
    }

    /**
     * 保存一条
     */
    private void saveSingle() {
        ContentBean mBean = new ContentBean();
        mBean.setEmail("282921012@qq.com");
        mBean.setName("七八一零");
        mBean.setQQ("282921012");
        mBean.setGit("1");
        mBean.save();
    }

    /**
     * 读取一条
     */
    private void readSingle() {
        ContentBean contentBeanList = SQLite.select().
                from(ContentBean.class).querySingle();
        if (contentBeanList != null)
            Log.d(TAG, "contentBeanList: " + contentBeanList.getEmail());
    }

    /**
     * 保存多条
     */
    private void saveList() {
        Log.d(TAG, "SourceList.getList: "+ SourceList.getList().size());
        FlowManager.getDatabase(MyDatabase.class)
                .getTransactionManager()
                .getSaveQueue()
                .addAll2(SourceList.getList());

        FlowManager.getDatabase(MyDatabase.class).getTransactionManager().getSaveQueue().purgeQueue();
    }

    /**
     * 读取多条
     */
    private void readList() {
        List<ContentBean> contentBeanList = SQLite.select().
                from(ContentBean.class).queryList();
        Log.d(TAG, "contentBeanList.size  is:: " + contentBeanList.size());
        if (contentBeanList.size() > 0)
            Log.d(TAG, "contentBeanList: 1::" + contentBeanList.get(0).getName());
    }
}
