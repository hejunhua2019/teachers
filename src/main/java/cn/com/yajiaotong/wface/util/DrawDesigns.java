package cn.com.yajiaotong.wface.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * ��ͼ����,��Ҫ��������ά����άͼ��(��״ͼ,��״ͼ,����ͼ) 
 * ʹ��˵����
 * 1, ���������һ�����캯��,������캯����Ĳ�����������Ҫ��,�����ͨ��get/set��������. 
 * 2, �����Լ�����Ҫ��ʲô����ͼ�͵���ʲô������ 
 * 3, ���ӣ� DrawDesigns d = new DrawDesigns(......); String str = d.drawPie2D();
 * ���str��������ȫ������,ǰ̨����ֱ��ʹ���������(str),ע��ҳ�治�õ���js�ļ���
 * ǰ̨ҳ��:(����jspҳ��) ${str} ���� <%=str%>
 * 
 * @author joe
 * 
 */
public class DrawDesigns {

	// default params
	private static final String CAPTION = "ͳ�Ʒ���ͼ";

	private static final String XAXISNAME = "����Դ����";

	private static final String YAXISNAME = "Value";

	private static final Integer WIDTH = 600;// Ĭ�ϵĿ��,��˼ͬwidth����һ��

	private static final Integer HEIGHT = 400;// Ĭ�ϵĸ߶�,��˼ͬheight����һ��

	private static final String JSPATH = "FusionChartsFree/JSClass/FusionCharts.js";

	private static final String SWFPATH = "FusionChartsFree/Charts/";

	// private static final String XMLHEADER = "<?xml version=\"1.0\"
	// encoding=\"UTF-8\"?>";

	// user-defind
	private String caption;// ͼ�εı�������

	private String xAxisName;// ����������(x��)����

	private String yAxisName;// ����������(y��)����

	private Integer width;// x���,��ʵ���ó�Double���͵ı���Ҳ����,����û�б�Ҫ���㵽������,Integer�͹���,����ҵ���б�Ҫ��˵��

	private Integer height;// y���,��ʵ���ó�Double���͵ı���Ҳ����,����û�б�Ҫ���㵽������,Integer�͹���,����ҵ���б�Ҫ��˵��

	private String jsPath;// ����д����˼��FusionCharts����������Լ�д���ļ�������ͬһ��Ŀ¼��,Ĭ�ϵ�js·���������

	private String swfPath;// ���ֻ��ָ������,��Ϊ���Charts������ȫ��swf�ļ�,ֻ�ܸ��ݿͻ������swf�ļ�

	private String divId = "drawDiv" + UUID.randomUUID().toString();// �ѷ�װ�õ�xml���ݷŵ�ǰ̨ҳ����ʾ���ĸ�����,����div,����areaName��˼��ָ��������������,�������һ��Ĭ�ϵġ�

	private String colors[] = { "1D8BD1", "F1683C", "2AD62A", "DBDC25",
			"649665", "4169E1", "087eb6", "BA55D3", "D2691E", "FF7F50",
			"32CD32", "4682B4" };// ָ����ɫ,���Ը����Լ���ϲ�����д,�������ĳ��Ȳ���,��Ҫ����ʾͼ��ʱ������,�����Ū��ͳһ����ɫ,��ܵ���,���Կ��Ǳ�д�������ɫ����

	private String myChartName;

	// һά����(��˼�Ǳ�������ͼ��ֻ��ʾһ������)
	private List<Map<Object, Object>> oneDimensionsList = new ArrayList<Map<Object, Object>>();

	// ��ά����(��˼�Ǳ�������ͼ����ʾ��������)
	private Map<Object, Map<Object, Object>> manyDimensionsMap = new HashMap<Object, Map<Object, Object>>();

	// x�����Ƽ���(�����������������õ�,��Ҫ�Ƕ�����Ϲ���x������)
	private List<String> xAxisNameList = new ArrayList<String>();

	private boolean benchmark = false;//�Ƿ���ʾ��׼��

	private String benchmarkName;//��׼������

	private Object benchmarkValue;//��׼��ֵ

	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public DrawDesigns() {
		this.verifyParams();
	}

	/**
	 * ���һά�����������Ĺ��췽��
	 * @param caption
	 * @param xAxisName
	 * @param yAxisName
	 * @param width
	 * @param height
	 * @param oneDimensionsList
	 */
	public DrawDesigns(String caption, String xAxisName, String yAxisName,
			Integer width, Integer height, List<Map<Object, Object>> oneDimensionsList) {
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.width = width;
		this.height = height;
		this.oneDimensionsList = oneDimensionsList;
		this.verifyParams();
	}

	/**
	 * ���һά�����������Ĺ��췽��,�÷�������js·��
	 * @param caption
	 * @param xAxisName
	 * @param yAxisName
	 * @param width
	 * @param height
	 * @param jsPath
	 * @param swfPath
	 * @param oneDimensionsList
	 */
	public DrawDesigns(String caption, String xAxisName, String yAxisName,
			Integer width, Integer height, String jsPath, String swfPath,
			List<Map<Object, Object>> oneDimensionsList) {
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.width = width;
		this.height = height;
		this.jsPath = jsPath;
		this.swfPath = swfPath;
		this.oneDimensionsList = oneDimensionsList;
		this.verifyParams();
	}

	/**
	 * �ù��췽����Ϊ��ά����д�ģ�
	 * List<String>������x�������,
	 * Map<Object, Map<Object, Object>>������ÿһά����Ӧ��ֵ�ļ���.
	 * ����:List<String> = {"һ��","����","����","����","����"}
	 * Map<Map<Object, Map<Object, Object>>> 
	 * = {
	 * {2009��,{{"һ��",100},{"����",200},{"����",300}...}},
	 * {2010��,{{"һ��",100},{"����",200},{"����",300}...}}...
	 * }
	 * @param caption
	 * @param xAxisName
	 * @param yAxisName
	 * @param width
	 * @param height
	 * @param jsPath
	 * @param swfPath
	 * @param xAxisNameList
	 * @param manyDimensionsMap
	 */
	public DrawDesigns(String caption, String xAxisName, String yAxisName,
			Integer width, Integer height, String jsPath, String swfPath,
			List<String> xAxisNameList,
			Map<Object, Map<Object, Object>> manyDimensionsMap) {
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.width = width;
		this.height = height;
		this.jsPath = jsPath;
		this.swfPath = swfPath;
		this.xAxisNameList = xAxisNameList;
		this.manyDimensionsMap = manyDimensionsMap;
	}
	
	/**
	 * ��Զ�ά�����������Ĺ��췽��
	 * ͬ��һ��,ֻ�����ǲ���js·��
	 * @param caption
	 * @param xAxisName
	 * @param yAxisName
	 * @param width
	 * @param height
	 * @param xAxisNameList
	 * @param manyDimensionsMap
	 */
	public DrawDesigns(String caption, String xAxisName, String yAxisName,
			Integer width, Integer height, List<String> xAxisNameList,
			Map<Object, Map<Object, Object>> manyDimensionsMap) {
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.width = width;
		this.height = height;
		this.xAxisNameList = xAxisNameList;
		this.manyDimensionsMap = manyDimensionsMap;
	}

	/**
	 * ��ȡswf������·��
	 * 
	 * @param swfName
	 * @return
	 */
	private String getSWFPath(String swfName) {
		return this.swfPath + swfName;
	}

	/**
	 * �ͻ��п�����Ҫ�����,������������һ�´���ߵĲ���
	 * 
	 * @param ifBenchmark
	 *            �Ƿ���ʾ�����
	 * @param benchmarkName
	 *            ���������
	 * @param benchmarkValue
	 *            �����ֵ
	 */
	public void setBenchmark(boolean ifBenchmark, String benchmarkName,
			Object benchmarkValue) {
		this.benchmark = ifBenchmark;
		this.benchmarkName = benchmarkName;
		this.benchmarkValue = benchmarkValue;
	}

	/**
	 * ����û���ǰ̨�����ò���,�����������Ϊnull������"",��ô�������һ��Ĭ�ϵĲ���ֵ
	 */
	private void verifyParams() {
		if (this.width == null || this.width <= 0) {
			this.width = WIDTH;
		}
		if (this.height == null || this.height <= 0) {
			this.height = HEIGHT;
		}
		if (this.xAxisName == null || this.xAxisName.equals("")) {
			this.xAxisName = XAXISNAME;
		}
		if (this.yAxisName == null || this.yAxisName.equals("")) {
			this.yAxisName = YAXISNAME;
		}
		if (this.caption == null || this.caption.equals("")) {
			this.caption = CAPTION;
		}
		if (this.jsPath == null || this.jsPath.equals("")) {
			this.jsPath = JSPATH;
		}
		if (this.swfPath == null || this.swfPath.equals("")) {
			this.swfPath = SWFPATH;
		}
		if (this.myChartName == null || this.myChartName.equals("")) {
			this.myChartName = "myChart" + (new Random()).nextInt(10000);
		}
		if (this.oneDimensionsList.isEmpty()) {
			this.oneDimensionsList = new ArrayList<Map<Object,Object>>();
		}
		if (this.manyDimensionsMap.isEmpty()) {
			this.manyDimensionsMap = new HashMap<Object, Map<Object,Object>>();
		}
		if(this.xAxisNameList.isEmpty()) {
			this.xAxisNameList = new ArrayList<String>();
		}
		// ���´���(����forѭ��)���������õ�
/*		for (int i = 0; i < 10; i++) {
			int value = (new Random()).nextInt(100);
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("x", "���" + i);
			map.put("y", value);
			this.oneDimensionsList.add(map);
		}
		for (int i = 1; i <= 12; i++) {
			this.xAxisNameList.add(i + "");
		}
		for (int i = 0; i < 3; i++) {
			Map<Object, Object> m = new HashMap<Object, Object>();
			for (int j = 1; j <= this.xAxisNameList.size(); j++) {
				m.put(this.xAxisNameList.get(j - 1), (new Random())
						.nextInt(100));
			}
			this.manyDimensionsMap.put("201" + i, m);
		}
*/
	}

	/**
	 * ����js
	 * 
	 * @return
	 */
	private String getDivAndJs() {
		return "<div style=\"width: 0px; height: 0px\"><script type=\"text/javascript\" src=\""
				+ this.jsPath
				+ "\"></script></div>"
				+ "<div id=\""
				+ this.divId + "\" align = \"center\">Fusion Chart.</div>";
	}

	/**
	 * ����һάͼ�ε�xml����
	 * 
	 * @return
	 */
	private String getOneDimensionsXmlData() {
		StringBuffer buffer = new StringBuffer("");
		buffer
				.append("<chart caption='")
				.append(this.caption)
				.append("' xAxisName='")
				.append(this.xAxisName)
				.append("' yAxisName='")
				.append(this.yAxisName)
				.append(
						"' showNames='1' decimalPrecision='0' baseFontSize='12'  formatNumberScale='0' >");
		for (Map<Object, Object> map : this.oneDimensionsList) {
			buffer.append("<set label='").append(map.get("x")).append(
					"' value='").append(map.get("y")).append("' color='")
					.append(this.getRandomColor()).append("' />");
		}
		buffer.append("</chart>");
		return buffer.toString();
	}

	/**
	 * ��ͼ,��Ҫ�ǰ�js,xml,swf�����ݷ�װ����
	 * 
	 * @param swfName
	 * @param xmlData
	 * @return
	 */
	private String getDrawChart(String swfName, String xmlData) {
		StringBuffer buffer = new StringBuffer(this.getDivAndJs()
				+ "<script type=\"text/javascript\"> ");
		buffer.append("var ").append(this.myChartName).append(
				"= new FusionCharts(\"" + this.getSWFPath(swfName)
						+ "\", \"myChart" + UUID.randomUUID().toString()
						+ "\", \"" + this.width + "\", \"" + this.height
						+ "\", \"0\", \"0\"); ").append(this.myChartName)
				.append(".setDataXML(\"" + xmlData + "\"); ").append(
						this.myChartName).append(".render(\"").append(
						this.divId).append("\");</script>");
		return buffer.toString();
	}

	/**
	 * ������άͼ�ε�xml����
	 * 
	 * @return
	 */
	private String getManyDimensionsXmlData() {
		StringBuffer buffer = new StringBuffer("");
		buffer
				.append("<chart caption='")
				.append(this.caption)
				.append("' xAxisName='")
				.append(this.xAxisName)
				.append("' yAxisName='")
				.append(this.yAxisName)
				.append(
						"' showValues='0' baseFontSize='12' palette='1' showFCMenuItem='1' imageSave='1'>");
		buffer.append("<categories>");
		for (String str : xAxisNameList) {
			buffer.append("<category label='" + str + "' />");
		}
		buffer.append("</categories>");
		for (Map.Entry<Object, Map<Object, Object>> values : this.manyDimensionsMap.entrySet()) {
			buffer.append("<dataset seriesName='").append(values.getKey()).append("'>");
			for (String str : this.xAxisNameList) {
				buffer.append("<set value='").append(values.getValue().get(str)).append("'/>");
			}
			buffer.append("</dataset>");
		}
		buffer.append(this.benchmark());
		buffer.append("</chart>");
		return buffer.toString();
	}

	/**
	 * ��װ����ߵ�xml����
	 * @return
	 */
	private String benchmark() {
		StringBuffer buffer = new StringBuffer("");
		if (this.benchmark
				&& (this.benchmarkName != null && !this.benchmarkName
						.equals(""))
				&& (this.benchmarkValue != null && !this.benchmarkValue
						.equals(""))) {
			buffer.append("<trendlines><line startValue='").append(
					this.benchmarkValue).append(
					"' color='91C728' displayValue='").append(
					this.benchmarkName).append(
					"' showOnTop='1' /></trendlines>");
		}
		return buffer.toString();
	}
	
	/**
	 * ��colors�������ѡȡһ����ɫ
	 * 
	 * @return
	 */
	private String getColor() {
		if (oneDimensionsList.size() <= 0) {
			return this.colors[(new Random()).nextInt(this.colors.length)];
		} else {
			return this.colors[(new Random()).nextInt(oneDimensionsList.size())];
		}
	}

	/**
	 * ���������ɫ
	 * 
	 * @return
	 */
	private String getRandomColor() {
		return (UUID.randomUUID().toString()).substring(0, 6);
	}

	/**
	 * 2ά��״ͼ
	 * 
	 * @return
	 */
	public String drawPie2D() {
		return this.getDrawChart("Pie2D.swf", this.getOneDimensionsXmlData());

	}

	/**
	 * 3ά��״ͼ
	 * 
	 * @return
	 */
	public String drawPie3D() {
		return this.getDrawChart("Pie3D.swf", this.getOneDimensionsXmlData());
	}

	/**
	 * 2ά��״ͼ
	 * 
	 * @return
	 */
	public String drawColumn2D() {
		return this
				.getDrawChart("Column2D.swf", this.getOneDimensionsXmlData());
	}

	/**
	 * 3ά��״ͼ
	 * 
	 * @return
	 */
	public String drawColumn3D() {
		return this
				.getDrawChart("Column3D.swf", this.getOneDimensionsXmlData());
	}

	/**
	 * 2ά����ͼ
	 * 
	 * @return
	 */
	public String drawLine2D() {
		return this.getDrawChart("Line.swf", this.getOneDimensionsXmlData());
	}

	/**
	 * 3ά����ͼ
	 * ���������ʱ����ʹ��,��Ϊ��������ͼһά���ݵ�swf�ļ���ʱû�ҵ�
	 * @return
	 */
	public String drawLine3D() {
		return this.getDrawChart("Line.swf", this.getOneDimensionsXmlData());
	}

	// ==============�����Ƕ�ά������״ͼ,����ͼ===============

	/**
	 * ��ά2D��״ͼ
	 * 
	 * @return
	 */
	public String drawColumn2DGroup() {
		return this.getDrawChart("MSColumn2D.swf", this
				.getManyDimensionsXmlData());
	}

	/**
	 * ��ά2D����ͼ
	 * 
	 * @return
	 */
	public String drawLine2DGroup() {
		return this.getDrawChart("MSLine.swf", this.getManyDimensionsXmlData());
	}

	/**
	 * ��ά3D��״ͼ
	 * 
	 * @return
	 */
	public String drawColumn3DGroup() {
		return this.getDrawChart("MSColumn3D.swf", this
				.getManyDimensionsXmlData());
	}

	/**
	 * ��ά3D����ͼ
	 * 
	 * @return
	 */
	public String drawLine3DGroup() {
		return this.getDrawChart("MSLine.swf", this
				.getManyDimensionsXmlData());
	}

	// ==========get/set����begin==============

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getXAxisName() {
		return xAxisName;
	}

	public void setXAxisName(String axisName) {
		xAxisName = axisName;
	}

	public String getYAxisName() {
		return yAxisName;
	}

	public void setYAxisName(String axisName) {
		yAxisName = axisName;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getJsPath() {
		return jsPath;
	}

	public void setJsPath(String jsPath) {
		this.jsPath = jsPath;
	}

	public String getSwfPath() {
		return swfPath;
	}

	public void setSwfPath(String swfPath) {
		this.swfPath = swfPath;
	}

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	public String getMyChartName() {
		return myChartName;
	}

	public void setMyChartName(String myChartName) {
		this.myChartName = myChartName;
	}

	public List<Map<Object, Object>> getOneDimensionsList() {
		return oneDimensionsList;
	}

	public void setOneDimensionsList(List<Map<Object, Object>> oneDimensionsList) {
		this.oneDimensionsList = oneDimensionsList;
	}

	public Map<Object, Map<Object, Object>> getManyDimensionsMap() {
		return manyDimensionsMap;
	}

	public void setManyDimensionsMap(
			Map<Object, Map<Object, Object>> manyDimensionsMap) {
		this.manyDimensionsMap = manyDimensionsMap;
	}

	public List<String> getXAxisNameList() {
		return xAxisNameList;
	}

	public void setXAxisNameList(List<String> axisNameList) {
		xAxisNameList = axisNameList;
	}

	public boolean isBenchmark() {
		return benchmark;
	}

	public void setBenchmark(boolean benchmark) {
		this.benchmark = benchmark;
	}

	public String getBenchmarkName() {
		return benchmarkName;
	}

	public void setBenchmarkName(String benchmarkName) {
		this.benchmarkName = benchmarkName;
	}

	public Object getBenchmarkValue() {
		return benchmarkValue;
	}

	public void setBenchmarkValue(Object benchmarkValue) {
		this.benchmarkValue = benchmarkValue; 
	}
	// ================get/set����end============
}