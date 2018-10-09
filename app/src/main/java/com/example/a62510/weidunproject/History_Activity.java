package com.example.a62510.weidunproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.a62510.weidunproject.R.layout.chart_marker_view;

public class History_Activity extends AppCompatActivity {
    private ArrayList<String> mXData = new ArrayList<>();
    private LineChartManager mChartManager;
    private MyMarkerView mMarkerView;
    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_);
        setTitle("薇盾");
        mLineChart = (LineChart) findViewById(R.id.chart_my_fof_line_chart);

        // 初始化表格manager
        mChartManager = new LineChartManager(mLineChart);
        mMarkerView = new MyMarkerView(this, chart_marker_view);
        mChartManager.setMarkView(mMarkerView);

        ArrayList<MyFofChartBean> list = new ArrayList<>();
        int len = 12;
        for (int i = 0; i < len; i++) {
            MyFofChartBean bean = new MyFofChartBean();
            bean.networth = (1.30f + i);
            if (i < 9) {
                bean.inputDate = "2018/0" + (i + 1);
            } else {
                bean.inputDate = "2018/" + (i + 1);
            }
            list.add(bean);
        }

        mLineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            private Highlight mHighlight;

            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                mHighlight = highlight;
            }

            @Override
            public void onNothingSelected() {

                if (mHighlight == null) {
                    mHighlight = new Highlight(mMarkerView.getHighlightXValue(), mMarkerView.getHighlightYValue(), 1);
                }
                mMarkerView.showMarkView(mHighlight.getX(), mHighlight.getY());
            }
        });


        setLineChartData(list);

    }


    private void setLineChartData(List<MyFofChartBean> list) {
        if (list != null && !list.isEmpty()) {
            mXData.clear();
            int size = list.size();
            List<Entry> entries = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                MyFofChartBean dataBean = list.get(i);
                if (dataBean != null) {
                    if (!Float.isNaN(dataBean.networth)) {
                        Entry e = new Entry((float) i, dataBean.networth,getResources().getDrawable(R.drawable.icon_chart_dot));
                        entries.add(e);
                    }
                    mXData.add(dataBean.inputDate);
                }
            }

            XAxis xAxis = mLineChart.getXAxis();
            xAxis.setLabelCount(list.size());
            xAxis.setValueFormatter(new IAxisValueFormatter() {
                @Override
                public String getFormattedValue(float v, AxisBase axisBase) {
                    int i = (int) v;
                    // 只显示首尾日期
                    if (i == 0 || i == mXData.size() - 1) {
                        return mXData.get(i);
                    } else {
                        return "";
                    }
                }
            });

            // 设置lineChart的数据
            mChartManager.setData(entries);
            // 给y轴设置最大值
            float yMax = mLineChart.getYMax();
            mLineChart.getAxisLeft().setAxisMaximum(yMax + 2.0f);

            // 设置X轴的label的集合
            mMarkerView.setXAxisLabels(mXData);
            // 指定最后一个点为高亮，让其自定显示MarkView
            Entry entry = entries.get(size - 1);
            mMarkerView.showMarkView(entry.getX(), entry.getY());

            mLineChart.animateXY(800, 800);
            mLineChart.invalidate();
        }
    }
}