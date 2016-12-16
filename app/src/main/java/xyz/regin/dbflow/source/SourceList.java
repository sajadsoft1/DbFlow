package xyz.regin.dbflow.source;

import java.util.ArrayList;

import xyz.regin.dbflow.bean.ContentBean;

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
 * @author Reginer on  2016/12/12 15:54.
 *         Description:数据集合
 */
public class SourceList {
    private static ArrayList<ContentBean> mList;

    public static ArrayList<ContentBean> getList() {
        if (mList == null || mList.isEmpty()) {
            mList = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                mList.add(new ContentBean("熊" + i, i + "@qq.com", String.valueOf(i), i + "git"));
            }
        }
        return mList;
    }

}