import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.TextField;
import java.io.FileOutputStream;

public class TestPdf {

    public static void main(String[] args) throws Exception {
        
        PdfReader reader=new PdfReader("Doc1.pdf");
        PdfStamper stamp=new PdfStamper(reader, new FileOutputStream("testpdf.pdf"));
        Image img1 = Image.getInstance("d://HIT java/certificate.png");
        PdfContentByte c=stamp.getUnderContent(1);
        img1.setAbsolutePosition(0,0);
        img1.scaleToFit(PageSize.A3.getWidth(),PageSize.A3.getHeight());
        c.addImage(img1);
       
        BaseFont bold = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE,BaseFont.WINANSI,BaseFont.EMBEDDED);
        
        String name="Ms.Samiksha Chodankar";
        TextField txt=new TextField(stamp.getWriter(), new Rectangle(770,200,100,370), "newtxt");
        txt.setOptions(TextField.READ_ONLY);
        txt.setAlignment(Element.ALIGN_CENTER);
        txt.setTextColor(BaseColor.WHITE);
        txt.setFont(bold);
        txt.setFontSize(30);
        txt.setText(name);
        stamp.addAnnotation(txt.getTextField(),1);
  
        stamp.close();
        reader.close();
    }
}
