package org.mfoyou.agent.common.OP;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;


public class BaseYinianUtil {
	public static final String CLIENT_ID = "1054621254";
	public static final String client_secret = "a3d04ec0f03c91d4ab95c6cf593d8401";
	public static Methods methods;
//	public static final String MACHINE_CODE= "4004548686";
	
	static{
		methods = Methods.getInstance();
		methods.init(CLIENT_ID, client_secret);
	}
	/**
	 * 打印
	 * @param withPackage
	 * @param token
	 * @return
	 */
	public  static String print(MfoyouGoodsOrderWithPackage withPackage,String token,int model){
		String printNumber = withPackage.getStoreInfo().getStorePrinterNumber();
		return methods.print(printNumber,token,getAu(withPackage,model), withPackage.getOrderNumber());
	}
	private static String getAu(MfoyouGoodsOrderWithPackage withPackage,int model){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		List<MfoyouGoodsOrderItme> goodsOrderItmes = withPackage.getGoodsOrderItmes();
		if(model == 0){
			builder.append("<MS>1,2</MS>\n");
		}else{
			builder.append("<MS>0,2</MS>\n");
		}
		String orderNumber = withPackage.getOrderNumber();
		
		builder.append("_______________________________\n")
			   .append(format.format(new Date()))
		 	   .append("\n<center>------------------------------</center>")
			   .append("<FB><center><FS>#"+
		 	   Integer.parseInt(orderNumber.substring(orderNumber.length()-4,orderNumber.length()))
			   +" 华悟云购</FS></center></FB>")
			   .append("<center>"+withPackage.getStoreName()+"</center>")
			   .append("<FS><center>在线已支付</center></FS>")
			   .append("<center>期待送达时间:立即送达</center>")
			   .append("<center>订单号："+withPackage.getOrderNumber()+"</center>")
			   .append("<center>下单时间： "+format.format(withPackage.getOrderPayTime())+"</center>")
			   .append("<center>-------------商品---------------</center>");
			   for(int i=0;i<goodsOrderItmes.size();i++){
				   MfoyouGoodsOrderItme mfoyouGoodsOrderItme = goodsOrderItmes.get(i);
				   builder.append("<FS><table><tr><td>"+mfoyouGoodsOrderItme.getGoodsName());
				   if(mfoyouGoodsOrderItme.getPackageName()!=null){
					   builder.append("["+mfoyouGoodsOrderItme.getPackageName()+"]");
				   }	  
				   builder.append("</td><td>X"+mfoyouGoodsOrderItme.getItemNumber())
				   		  .append("</td><td>"+formatPrice(mfoyouGoodsOrderItme.getItemTotalAmount())+"</td></tr></table></FS>");
			   }
			   builder.append("<center>------------------------------</center>")
			   .append("配送费："+formatPrice(withPackage.getOrderFreightAmount())+"\n");
			   //优惠活动 
			   if(withPackage.getOrderActiveId()!=null){
				   String key = withPackage.getOrderActiveId().intValue() == 201 ? "满减优惠" : "新用户立减";
				   builder.append("<FS><table><tr><td>"+key+"</td><td></td><td>"+
				   formatPrice(withPackage.getOrderActiveAmount())+"</td></tr></table></FS>");
			   }
			   builder.append("<center>------------------------------</center>")
			   .append("<FB><FS><right>总计:￥ "+formatPrice(withPackage.getOrderTotalAmount())+"</right></FS></FB>")
			   .append("<center>------------------------------</center>")
			   .append("<FB><FS>"+withPackage.getOrderUserAddress()+"</FS>\n")
			   .append("<FS>"+withPackage.getOrderUserPhone()+"</FS>\n")
			   .append("<FS>"+withPackage.getOrderUserName());
			   if(withPackage.getOrderUserSex() !=null){
				   String userSex = withPackage.getOrderUserSex() == 1 ? "先生" : "女士";
				   builder.append("("+userSex+")");
			   }
			   builder.append("</FS></FB>\n")
			   .append("<center>--------------------------------</center>")
			   .append("师傅您辛苦了！\n 华悟云购携顾客感谢你的用心服务!\n")
			   .append("<QR>http://www.huawucloud.com</QR>")
			   ;
		return builder.toString();
	}
	private static String formatPrice(Integer acount){
		DecimalFormat   df   =new   DecimalFormat("#0.00");  
		Double intValue = (double) acount.intValue();
		return df.format(intValue/100);
	}
}
