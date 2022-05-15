package ptt;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import javax.swing.JOptionPane;

public class UI extends javax.swing.JFrame 
{
    public UI() {
        initComponents();
    }
    
        // 宣告Swing元件變數                    
    private javax.swing.JButton btChoose;
    private javax.swing.JButton btRun;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfCount;
    private javax.swing.JTextField tfPath;
    private javax.swing.JTextField tfPushCount;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        cbType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPath = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfCount = new javax.swing.JTextField();
        btRun = new javax.swing.JButton();
        tfPushCount = new javax.swing.JTextField();
        btChoose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "正妹", "帥哥" }));

        jLabel1.setText("爬文類型");

        jLabel2.setText("推文門檻");

        jLabel3.setText("儲存路徑");

        jLabel4.setText("預爬文數");

        tfCount.setText("30");

        btRun.setText("執行");
        btRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btRunMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tfPushCount.setText("10");

        btChoose.setText("選取路徑"); 
        btChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChooseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPushCount, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPath, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btChoose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btRun, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfCount, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPushCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btRun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                       

    //執行按鈕點選事件
    private void btRunMouseClicked(java.awt.event.MouseEvent evt) throws IOException {
        if(tfPath.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "請設定儲存路徑", "提示: ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
       
            String url = "https://www.ptt.cc/bbs/Beauty/index.html";
            Document index = Jsoup
                    .connect(url)
                    .userAgent("Mozilla")
                    .cookie("over18", "1") ////過18禁限制
                    .get(); 
            String secondPage = index.select("a:containsOwn(‹ 上頁)").attr("href");
            int startIndex = Integer.parseInt(secondPage.substring(secondPage.indexOf("index")+5,secondPage.indexOf("index")+9))+1;
            
            Print("Type : "+ cbType.getSelectedItem().toString()); //帥哥或是正妹
            Print("Count : "+ tfCount.getText()); //推文數
            Print("PushCount : "+ tfPushCount.getText()); //推文門檻
            int crawlerCount = Integer.parseInt(tfCount.getText());  //parse成整數型態
            int pushCount = Integer.parseInt(tfPushCount.getText()); 
            
            for(int i = startIndex;i>0;i--) 
            {
                try //例外處理
                {
                    url = "https://www.ptt.cc/bbs/Beauty/index"+i+".html";
                index = Jsoup
                    .connect(url)
                    .userAgent("Mozilla")
                    .cookie("over18", "1")
                    .get();
                Elements allElements = index.select("div.r-ent");
                for(Element item : allElements)
                {
                    if(!item.select("span").text().isEmpty() && item.select("span").text()!= null)
                    {
                        if(item.select("a").first().text().contains(cbType.getSelectedItem().toString()))
                        {
                            if(item.select("span").text().equals("爆") ) //爆文 優質
                            {
                                Element targetElement = item.select("a").first();
                                SaveImage("https://www.ptt.cc"+targetElement.attr("href"), targetElement.text()); //存圖
                                crawlerCount--; //遞減爬文數
                                if(crawlerCount<=0)
                                    break;
                            }
                            else if(item.select("span").text().contains("X")) //被噓爛的文章
                            {
                                continue; //直接跳過
                            }
                            else
                            {  
                                if(pushCount<Integer.parseInt(item.select("span").text())) //大於設定推文數的文章
                                {
                                    Element targetElement = item.select("a").first();
                                    SaveImage("https://www.ptt.cc"+targetElement.attr("href"), targetElement.text()); //存圖
                                    crawlerCount--;
                                    if(crawlerCount<=0)
                                        break;
                                }
                            }
                        }
                    }
                    else
                        continue;
                }
                if(crawlerCount<=0)
                {
                    JOptionPane.showMessageDialog(null, "完成", "提示", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                }
                catch(Exception ex)
                {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    ex.printStackTrace(pw);
                    String sStackTrace = sw.toString();
                    Print("發生例外\r\n"+ex.getMessage()+"\r\n"+sStackTrace);
                }
            }
    }                                  
    
    //選擇路徑以及Click事件啟動爬蟲
    private void btChooseMouseClicked(java.awt.event.MouseEvent evt) {    //選擇路徑的button click listenr                                  
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);
        Print(f.getCurrentDirectory().toString());
        tfPath.setText(f.getSelectedFile().toString());
    }
    
    private void Print(String parameter) //偵錯用 command line訊息
    {
        System.out.println(parameter);
    }
    
    private void SaveImage(String url, String folderName) throws IOException //存圖片的func
    {
        String path = tfPath.getText()+"\\"+folderName; //從GUI得到想要存取的路徑
        File testFile = new File(path);
        if(!testFile.exists())
        {
            testFile.mkdir(); //沒有此資料夾就新增一個
        }
        //Print("抓 :"+url+"\r\n存到 :"+tfPath.getText()+"\\"+folderName);
        Print(folderName);
        
        Document index = Jsoup
                    .connect(url)
                    .userAgent("Mozilla")
                    .cookie("over18", "1")
                    .get();
                Element mainElement = index.select("div.main-content").first();
                Elements allA = index.select("a");
                int autoIncreaseIndex = 0;
                for(Element item : allA)
                {
                    
                    if(item.attr("href").contains("jpg"))
                    {
                        URL downlaodURL = new URL(item.attr("href"));
                        InputStream in = new BufferedInputStream(downlaodURL.openStream()); //IO流
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (-1!=(n=in.read(buf)))
                        {
                           out.write(buf, 0, n);
                        }
                        out.close();
                        in.close();
                        byte[] response = out.toByteArray();
                        FileOutputStream fos = new FileOutputStream(tfPath.getText()+"\\"+folderName+"\\"+autoIncreaseIndex+".jpg");
                        fos.write(response);
                        fos.close();
                        autoIncreaseIndex++;
                        
                        
                    }
                }
    }
    
    
    public static void main(String args[]) { //例外處理
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { //override run function
                new UI().setVisible(true);
            }
        });
    }


                      
}
