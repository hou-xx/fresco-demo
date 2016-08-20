# fresco-demo
/********************************************************/
#这个仓库会作为测试其他项目的目的而存在
/********************************************************/

# Modle introduce

1、使用fresco加载网络gif图 并控制播放

2、新建Module测试高度自适应listview工具类
这种方法会多次执行 adapter的getView方法 有时不可用
重写ListView的onMeasure方法更加合适
public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

3、测试PhotoView的Modle PhotoView支持手势缩放

4、测试CountDowmTimer的Modle
非常方便的实现倒计时



