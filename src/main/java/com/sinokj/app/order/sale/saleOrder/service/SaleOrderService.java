 package com.sinokj.app.order.sale.saleOrder.service;
 
  import com.lowagie.text.Document;
 import com.lowagie.text.Font;
 import com.lowagie.text.HeaderFooter;
 import com.lowagie.text.Paragraph;
 import com.lowagie.text.Phrase;
 import com.lowagie.text.pdf.BaseFont;
 import com.lowagie.text.pdf.PdfPCell;
 import com.lowagie.text.pdf.PdfPTable;
 import com.lowagie.text.pdf.PdfWriter;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.code.service.BaseService;

 import java.io.ByteArrayOutputStream;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class SaleOrderService extends BaseService<SaleOrder>
 {
   private SaleOrderService saleOrderService;
   private SaleWareService saleWareService;
   private SaleOrder saleOrder;
   private SaleWare saleWare;
   private WareService wareService;
   private GoodService goodService;
   private List<SaleWare> saleWarelist;
   private WareSpecificationValService wareSpecificationValService;
 
   public void createSaleOrder(SaleOrder saleOrder, String[] wareIdArr, Double[] orderNumberArr, Double[] goodPriceArr, Double[] moneyArr, Double[] priceDiscountArr)
   {
   }
 
   public void updataDeliveryState(String orderId, String deliveryState)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("id", orderId);
     param.put("deliveryState", deliveryState);
     this.publicDAO.update("SaleOrder.SaleOrder_state", param);
   }
 
   public void updataState(String orderId)
   throws Exception
   {
	   if (StringUtils.isBlank(orderId)) {
		   throw new Exception("orderId is null");
	   }
	   Map param = new HashMap();
	   param.put("id", orderId);
	   this.publicDAO.update("SaleOrder.SaleOrder_state1", param);
   }
   
   public void updataPaymentState(String orderId, String paymentState)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("id", orderId);
     param.put("paymentState", paymentState);
     this.publicDAO.update("SaleOrder.SaleOrder_state", param);
   }
 
   public void updataDeliveryStateTime(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Map param = new HashMap();
     param.put("id", orderId);
     param.put("deliveryTime", dateFormat.format(new Date()));
     this.publicDAO.update("SaleOrder.SaleOrder_state", param);
   }
 
   public void updataPaymentStateTime(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Map param = new HashMap();
     param.put("id", orderId);
     param.put("paymentTime", dateFormat.format(new Date()));
     this.publicDAO.update("SaleOrder.SaleOrder_state", param);
   }
 
   public List<SaleOrder> getSaleOrderByMonthAgo(SaleOrder saleOrder)
     throws Exception
   {
     if (saleOrder == null) {
       throw new Exception("saleOrder is null!");
     }
     List list = this.publicDAO.select("SaleOrder.SaleOrder_month", saleOrder);
     return list;
   }
 
   public List<SaleOrder> getSaleOrderByOrderId(String orderId)
     throws Exception
   {
     if (orderId == null) {
       throw new Exception("orderId is null!");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     List list = this.publicDAO.select("SaleOrder.SaleOrder", param);
     return list;
   }
 
   public List<SaleOrder> getSumSaleOrderList(SaleOrder saleOrder)
   {
     List list = this.publicDAO.select("SaleOrder.SaleOrder", saleOrder);
     return list;
   }
 
   public List<SaleOrder> getSaleOrderByMonthToyear(SaleOrder saleOrder)
     throws Exception
   {
     if (saleOrder == null) {
       throw new Exception("saleOrder is null!");
     }
     List list = this.publicDAO.select("SaleOrder.SaleOrder_monthtoyear", saleOrder);
     return list;
   }
 
   public SaleOrder getOrderByZfbTradeNo(String zfbTradeNo)
     throws Exception
   {
     SaleOrder o = null;
     if (StringUtils.isBlank(zfbTradeNo)) {
       throw new Exception("saleOrder is null!");
     }
     SaleOrder objParam = new SaleOrder();
     objParam.setZfbTradeNo(zfbTradeNo);
     o = (SaleOrder)super.selectOne(objParam);
     return o;
   }
 
   public SaleOrder getOrderByOrderCode(String code) throws Exception {
     SaleOrder o = null;
     if (StringUtils.isBlank(code)) {
       throw new Exception("saleOrder is null!");
     }
     SaleOrder objParam = new SaleOrder();
     objParam.setCode(code);
     o = (SaleOrder)super.selectOne(objParam);
     return o;
   }
 
   public List<SaleWare> getSaleWareByIdlist(String saleorderId)
     throws Exception
   {
     List resultList = null;
 
     resultList = this.saleWareService.getWareBySaleId(saleorderId);
 
     for (int i = 0; i < resultList.size(); i++) {
       Ware ware = new Ware();
       ware = (Ware)this.wareService.getModel(((SaleWare)resultList.get(i)).getWareId());
       if (ware != null) {
         ((SaleWare)resultList.get(i)).setCode(ware.getCode());
         List wareSpecificationValList = this.wareSpecificationValService.getByWareId(ware.getId());
         String specificationVal = "";
         for (int j = 0; j < wareSpecificationValList.size(); j++) {
           specificationVal = specificationVal + ((WareSpecificationVal)wareSpecificationValList.get(j)).getSpecificationValName();
           if (j + 1 != wareSpecificationValList.size()) {
             specificationVal = specificationVal + ",";
           }
         }
         ((SaleWare)resultList.get(i)).setWareSpecificationVal(specificationVal);
         Good good = (Good)this.goodService.getModel(ware.getGoodId());
         if (good != null) {
           ((SaleWare)resultList.get(i)).setName(good.getName());
           ((SaleWare)resultList.get(i)).setGoodTypeName(good.getGoodTypeName());
         }
       }
     }
 
     return resultList;
   }
 
   public ByteArrayOutputStream createOrderPdf(SaleOrder saleOrder)
     throws Exception
   {
     this.saleWarelist = getSaleWareByIdlist(saleOrder.getId());
     Document document = new Document();
     ByteArrayOutputStream pdfFile = new ByteArrayOutputStream();
     SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     try {
       PdfWriter.getInstance(document, pdfFile);
       
       BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
       Font fontChinese = new Font(bfChinese, 12.0F, 0);
 
       Phrase footPhrase = new Phrase("单位：航天三院三〇四所客服中心\n", fontChinese);
       HeaderFooter footer = new HeaderFooter(footPhrase, true);
       footer.setBorder(0);
       footer.setAlignment(0);
       document.setFooter(footer);
 
       document.open();
 
       PdfPCell blankCell = new PdfPCell();
 
       PdfPTable headTable = new PdfPTable(3);
       headTable.setTotalWidth(560.0F);
       float[] columnWidths = { 2.0F, 4.0F, 3.0F };
       headTable.setWidths(columnWidths);
       headTable.setLockedWidth(true);
 
       /**String picPath = Static.APACHE_CONTEXT_PATH + "/Images/images/logo2.jpg";
       Image image = Image.getInstance(picPath);
       image.scaleAbsoluteHeight(50.0F);
       image.scaleAbsoluteWidth(110.0F);
       image.setAlignment(1);
       PdfPCell logoCell = new PdfPCell();
       logoCell.addElement(new Paragraph());
       logoCell.addElement(image);**/
       PdfPCell logoCell = new PdfPCell();
       logoCell.addElement(new Paragraph());
       logoCell.disableBorderSide(1);
       logoCell.disableBorderSide(2);
       logoCell.disableBorderSide(4);
       logoCell.disableBorderSide(8);
       headTable.addCell(logoCell);
 
       Paragraph title = new Paragraph(new Phrase("航天三院三〇四所-订单信息", fontChinese));
       title.setAlignment(1);
       title.setSpacingAfter(5.0F);
       PdfPCell titleCell = new PdfPCell();
       titleCell.addElement(new Paragraph());
       titleCell.addElement(title);
       titleCell.addElement(new Paragraph());
 
       titleCell.disableBorderSide(1);
       titleCell.disableBorderSide(2);
       titleCell.disableBorderSide(4);
       titleCell.disableBorderSide(8);
       headTable.addCell(titleCell);
 
       String code = saleOrder.getCode();
       Paragraph datePara = new Paragraph("打印日期:" + sm.format(new Date()).toString(), fontChinese);
       PdfPCell rightInfoCell = new PdfPCell();
       rightInfoCell.addElement(datePara);
 
       rightInfoCell.disableBorderSide(1);
       rightInfoCell.disableBorderSide(2);
       rightInfoCell.disableBorderSide(4);
       rightInfoCell.disableBorderSide(8);
 
       headTable.addCell(rightInfoCell);
       document.add(headTable);
       document.add(new Paragraph("\n"));
 
       PdfPTable infoTable = new PdfPTable(6);
       float[] infoTableWidths = { 2.0F, 3.5F, 2.0F, 2.0F, 1.5F, 3.0F };
       infoTable.setWidths(infoTableWidths);
       infoTable.setTotalWidth(560.0F);
 
       infoTable.setLockedWidth(true);
       PdfPCell orderInfoCell = new PdfPCell();
       orderInfoCell.addElement(new Paragraph("订 单 号 ", fontChinese));
       infoTable.addCell(orderInfoCell);
 
       PdfPCell ordervalueCell = new PdfPCell();
       ordervalueCell.addElement(new Paragraph(saleOrder.getCode()));
       infoTable.addCell(ordervalueCell);
 
       PdfPCell createtime = new PdfPCell();
       createtime.addElement(new Paragraph("开单日期", fontChinese));
       infoTable.addCell(createtime);
 
       PdfPCell createtimevalue = new PdfPCell();
       createtimevalue.addElement(new Paragraph(sm.format(saleOrder.getCreateTime()).toString()));
       infoTable.addCell(createtimevalue);
 
       PdfPCell handname = new PdfPCell();
       handname.addElement(new Paragraph("经手人", fontChinese));
       infoTable.addCell(handname);
 
       PdfPCell handnamevalue = new PdfPCell();
       handnamevalue.addElement(new Paragraph(saleOrder.getHandlerName(), fontChinese));
       infoTable.addCell(handnamevalue);
 
       PdfPCell customername = new PdfPCell();
       customername.addElement(new Paragraph("客    户", fontChinese));
       infoTable.addCell(customername);
 
       PdfPCell customernamevalue = new PdfPCell();
       customernamevalue.addElement(new Paragraph(saleOrder.getCustomerName(), fontChinese));
       infoTable.addCell(customernamevalue);
 
       PdfPCell linkmanname = new PdfPCell();
       linkmanname.addElement(new Paragraph("联系人", fontChinese));
       infoTable.addCell(linkmanname);
 
       PdfPCell linkmannamevalue = new PdfPCell();
       linkmannamevalue.addElement(new Paragraph(saleOrder.getLinkman(), fontChinese));
       infoTable.addCell(linkmannamevalue);
 
       PdfPCell mobilephone = new PdfPCell();
       mobilephone.addElement(new Paragraph("手机号", fontChinese));
       infoTable.addCell(mobilephone);
 
       PdfPCell mobilephonevalue = new PdfPCell();
       mobilephonevalue.addElement(new Paragraph(saleOrder.getMobile()));
       infoTable.addCell(mobilephonevalue);
 
       PdfPCell address = new PdfPCell();
       address.addElement(new Paragraph("联系人地址", fontChinese));
       infoTable.addCell(address);
 
       PdfPCell addressvalue = new PdfPCell();
       addressvalue.setColspan(2);
       addressvalue.addElement(new Paragraph(saleOrder.getAddress(), fontChinese));
       infoTable.addCell(addressvalue);
 
       PdfPCell warehouse = new PdfPCell();
       warehouse.addElement(new Paragraph("出货仓库", fontChinese));
       infoTable.addCell(warehouse);
 
       PdfPCell warehousevalue = new PdfPCell();
       warehousevalue.setColspan(2);
       warehousevalue.addElement(new Paragraph(saleOrder.getWarehouseName(), fontChinese));
       infoTable.addCell(warehousevalue);
 
       PdfPCell paymentname = new PdfPCell();
       paymentname.addElement(new Paragraph("支付方式", fontChinese));
       infoTable.addCell(paymentname);
 
       PdfPCell paymentnamevalue = new PdfPCell();
       paymentnamevalue.addElement(new Paragraph(saleOrder.getPaymentName(), fontChinese));
       infoTable.addCell(paymentnamevalue);
 
       PdfPCell deliveryname = new PdfPCell();
       deliveryname.addElement(new Paragraph("配送方式", fontChinese));
       infoTable.addCell(deliveryname);
 
       PdfPCell deliverynamevalue = new PdfPCell();
       deliverynamevalue.addElement(new Paragraph(saleOrder.getDeliveryName(), fontChinese));
       infoTable.addCell(deliverynamevalue);
 
       PdfPCell deliverycost = new PdfPCell();
       deliverycost.addElement(new Paragraph("配送费用", fontChinese));
       infoTable.addCell(deliverycost);
 
       PdfPCell deliverycostvalue = new PdfPCell();
       deliverycostvalue.addElement(new Paragraph(saleOrder.getDeliveryCost().toString()));
       infoTable.addCell(deliverycostvalue);
 
       PdfPCell totelprice = new PdfPCell();
       totelprice.addElement(new Paragraph("订单总额", fontChinese));
       infoTable.addCell(totelprice);
 
       PdfPCell totelpricevalue = new PdfPCell();
       totelpricevalue.setColspan(2);
       totelpricevalue.addElement(new Paragraph(saleOrder.getOrderMoney().toString()));
       infoTable.addCell(totelpricevalue);
       /**
       PdfPCell deliverymoey = new PdfPCell();
       deliverymoey.addElement(new Paragraph("优惠金额", fontChinese));
       infoTable.addCell(deliverymoey);
 
       PdfPCell deliverymoeyvalue = new PdfPCell();
       deliverymoeyvalue.setColspan(2);
       deliverymoeyvalue.addElement(new Paragraph("0"));
       infoTable.addCell(deliverymoeyvalue);
       **/  
       PdfPCell remark = new PdfPCell();
       remark.addElement(new Paragraph("备    注", fontChinese));
       infoTable.addCell(remark);
 
       PdfPCell remarkvalue = new PdfPCell();
       remarkvalue.setColspan(5);
       remarkvalue.addElement(new Paragraph(saleOrder.getRemark(), fontChinese));
       infoTable.addCell(remarkvalue);
 
       document.add(infoTable);
       document.add(new Paragraph("\n"));
 
       PdfPTable orderGoodTable = new PdfPTable(8);
       orderGoodTable.setTotalWidth(560.0F);
       orderGoodTable.setLockedWidth(true);
       float[] orderGoodWidths = { 3.5F, 4.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.5F };
       orderGoodTable.setWidths(orderGoodWidths);
       orderGoodTable.getDefaultCell().setMinimumHeight(15.0F);
 
       PdfPCell commentInfoCell = new PdfPCell();
 
       commentInfoCell.setColspan(8);
       commentInfoCell.setVerticalAlignment(1);
       commentInfoCell.addElement(new Paragraph("商品详细信息", fontChinese));
       orderGoodTable.addCell(commentInfoCell);
 
       orderGoodTable.addCell(new PdfPCell(new Paragraph("商品编号", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("商品名称", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("类别", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("规格 ", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("单价", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("订购数量", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("优惠金额", fontChinese)));
       orderGoodTable.addCell(new PdfPCell(new Paragraph("总价", fontChinese)));
       double temp=0;
       for (int i = 0; i < this.saleWarelist.size(); i++) {
         SaleWare saleWare = (SaleWare)this.saleWarelist.get(i);
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getCode())));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getName(), fontChinese)));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getGoodTypeName(), fontChinese)));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getWareSpecificationVal(), fontChinese)));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getGoodPrice().toString())));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getOrderNumber().toString())));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getPriceDiscount().toString())));
         orderGoodTable.addCell(new PdfPCell(new Paragraph(saleWare.getMoney().toString())));
         temp=temp+saleWare.getMoney();
       }
 
       int goodNum = this.saleWarelist.size();
       for (int i = 0; i < 10 - goodNum; i++) {
         for (int j = 0; j < 8; j++) {
           PdfPCell blankCell2 = orderGoodTable.getDefaultCell();
           orderGoodTable.addCell(blankCell2);
         }
       }
 
       double totelmoney = saleOrder.getOrderMoney().doubleValue();
       double delivercost = saleOrder.getDeliveryCost().doubleValue();
       double money = totelmoney + delivercost;
       PdfPCell totelInfoCell = new PdfPCell();
       totelInfoCell.setColspan(8);
       totelInfoCell.addElement(new Paragraph("￥订单总额:" + totelmoney + "+抵掉金额:" + (temp-totelmoney) + "  共计:" + money+"    客户签名:", fontChinese));
       orderGoodTable.addCell(totelInfoCell);
 
       document.add(orderGoodTable);
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       document.close();
     }
     return pdfFile;
   }
   public SaleOrderService getSaleOrderService() {
     return this.saleOrderService;
   }
   public void setSaleOrderService(SaleOrderService saleOrderService) {
     this.saleOrderService = saleOrderService;
   }
   public SaleOrder getSaleOrder() {
     return this.saleOrder;
   }
   public void setSaleOrder(SaleOrder saleOrder) {
     this.saleOrder = saleOrder;
   }
   public SaleWare getSaleWare() {
     return this.saleWare;
   }
   public void setSaleWare(SaleWare saleWare) {
     this.saleWare = saleWare;
   }
   public SaleWareService getSaleWareService() {
     return this.saleWareService;
   }
   public void setSaleWareService(SaleWareService saleWareService) {
     this.saleWareService = saleWareService;
   }
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
   public GoodService getGoodService() {
     return this.goodService;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
   public WareService getWareService() {
     return this.wareService;
   }
   public WareSpecificationValService getWareSpecificationValService() {
     return this.wareSpecificationValService;
   }
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService) {
     this.wareSpecificationValService = wareSpecificationValService;
   }
   public List<SaleWare> getSaleWarelist() {
     return this.saleWarelist;
   }
   public void setSaleWarelist(List<SaleWare> saleWarelist) {
     this.saleWarelist = saleWarelist;
   }
 }