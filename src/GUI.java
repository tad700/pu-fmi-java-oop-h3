import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class GUI {
    final int rogPrice = 5999;
    final int ideaPadPrice = 2699;
    final int acerNitro5Price = 1499;
    final int asusTUFPrice = 1759;
    final int redmiNote11Price = 370;
    final int galaxyS20Price = 1400;
    final int iphone14Price = 1800;
    final int huaweiP40Price = 899;
    final int sweatPantsPrice = 40;
    final int chinosPrice = 60;
    final int denimPrice = 80;
    final int shortDenimPrice = 50;
    Items items = new Items();
    String fileContent = "";
    String rogStrix = items.getRogStrix();
    String ideaPad = items.getIdeaPad();
    String acerNitro5 = items.getAcerNitro();
    String asusTUF = items.getAsusTuf();
    String redmiNote11 = items.getRedmiNote11();
    String iphone14 = items.getIphone14();
    String galaxyS20 = items.getGalaxyS20();
    String huaweiP40 = items.getHuaweiP40();
    String denim = items.getDenim();
    String chinos = items.getChinos();
    String sweatPants = items.getSweatPants();
    String shortDenim = items.getShortDenim();
    JPanel smartPhonePanel = new JPanel();
    JButton payPal = new JButton("PayPal");
    JButton debitCard = new JButton("Debit Card");
    JDialog cartWindow = new JDialog();
    private final ArrayList<Items> allItems = new ArrayList<>();
    //Panels
    private final JPanel laptopPanel = new JPanel();
    private final JPanel homePanel = new JPanel();
    private final   JPanel clothesPanel = new JPanel();

    ImageIcon iphone14Icon = new ImageIcon("iphone14.png");
    ImageIcon galaxyS20Icon = new ImageIcon("galaxys20.jpg");
    ImageIcon huaweiP40Icon = new ImageIcon("huaweip40.png");
    ImageIcon redmiNote11Icon = new ImageIcon("note11.jpg");
    //Jtrees
    private final JTree categoryTree;
    private final JButton iphone14Button = new JButton();
    private final JButton galaxyS20Button = new JButton();
    private final JButton huaweiP40Button = new JButton();
    private final JButton shortDenimButton = new JButton();
    private final JButton denimButton = new JButton();
    private final JButton chinosButton = new JButton();
    private final JButton sweatPantsButton = new JButton();


    //nodes
    private final DefaultMutableTreeNode shop = new DefaultMutableTreeNode("Магазин");
    private final DefaultMutableTreeNode electronics = new DefaultMutableTreeNode("Електроника");
    private final DefaultMutableTreeNode laptops = new DefaultMutableTreeNode("Лаптопи");
    private final DefaultMutableTreeNode gsm = new DefaultMutableTreeNode("Телефони");
    private final DefaultMutableTreeNode clothes = new DefaultMutableTreeNode("Дрехи");
    private final DefaultMutableTreeNode pants = new DefaultMutableTreeNode("Панталони");


    //Lables
    private final JLabel homeMessage = new JLabel();
    private final JLabel rogStrixLabel = new JLabel();
    private final JLabel ideaPadLabel = new JLabel();
    private final JLabel acerNitroLabel = new JLabel();
    private final JLabel asusTUFLabel = new JLabel();
    private final JLabel redmiNote11Label = new JLabel();
    private final JLabel galaxyS20Label = new JLabel();
    private final JLabel iphone14Label = new JLabel();
    private final JLabel huaweiP40Label = new JLabel();
    private final JLabel sweatPantsLabel = new JLabel();
    private final JLabel chinosLabel = new JLabel();
    private final JLabel denimLabel = new JLabel();
    private final JLabel shortDenimLabel = new JLabel();
    private final JLabel cartInfo = new JLabel();


    private final JLayeredPane layeredPane = new JLayeredPane();

    GUI() throws IOException {

        JFrame frame = new JFrame("Джурковия Магазин");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(layeredPane);
        layeredPane.setBounds(0, 0, 800, 800);


        FileWriter writer = new FileWriter("Cart.txt");


        //Начален екран
        homePanel.setBounds(250, 0, 550, 800);
        homePanel.setLayout(null);
        homePanel.setBackground(new Color(144, 229, 189));
        homePanel.add(homeMessage);
        homeMessage.setText("Добре Дошли, Изберете категория");
        homeMessage.setFont(new Font("Arial", Font.BOLD, 24));
        homeMessage.setBounds(10, 10, 550, 30);
        homeMessage.setVerticalTextPosition(JLabel.TOP);
        homeMessage.setHorizontalTextPosition(JLabel.CENTER);


        //Панела с категориите
        JPanel treePanel = new JPanel();
        treePanel.setBounds(0, 0, 250, 800);
        treePanel.setLayout(null);
        JTree laptopsTree = new JTree(electronics);
        JTree gsmTree = new JTree(gsm);
        categoryTree = new JTree(shop);
        categoryTree.setBounds(10, 10, 250, 300);

        shop.add(electronics);
        shop.add(clothes);

        JButton cart = new JButton("Количка");
        cart.setBounds(0, 700, 250, 50);
        cart.setBackground(Color.white);
        electronics.add(laptops);
        electronics.add(gsm);
        clothes.add(pants);

        treePanel.add(categoryTree);
        treePanel.add(cart);
        categoryTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) categoryTree.getLastSelectedPathComponent();
                Object input = node.getUserObject();
                System.out.println(input);
                if (input == laptops.getUserObject()) {
                    layeredPane.setLayer(smartPhonePanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(laptopPanel, JLayeredPane.DRAG_LAYER);
                    layeredPane.setLayer(homePanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(clothesPanel, JLayeredPane.DEFAULT_LAYER);
                } else if (input == gsm.getUserObject()) {
                    layeredPane.setLayer(laptopPanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(smartPhonePanel, JLayeredPane.DRAG_LAYER);
                    layeredPane.setLayer(homePanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(clothesPanel, JLayeredPane.DEFAULT_LAYER);
                }else if(input==pants.getUserObject()){
                    layeredPane.setLayer(laptopPanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(smartPhonePanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(homePanel, JLayeredPane.DEFAULT_LAYER);
                    layeredPane.setLayer(clothesPanel, JLayeredPane.DRAG_LAYER);


                }
            }
        });
        //Лаптоп панел
        laptopPanel.setBounds(250, 0, 550, 800);
        laptopPanel.setBackground(new Color(225, 198, 153));
        laptopPanel.setLayout(null);

        //Buttons
        JButton rogStrixButton = new JButton();
        rogStrixButton.setFocusable(false);
        //images
        ImageIcon rogStrixImage = new ImageIcon("rogstrix.png");
        rogStrixButton.setIcon(rogStrixImage);
        rogStrixButton.setBounds(10, 5, 220, 180);
        rogStrixButton.setBackground(Color.white);
        rogStrixButton.setOpaque(true);
        rogStrixButton.setText("Rog Strix " + rogPrice + " Лв.");
        rogStrixButton.setHorizontalTextPosition(JButton.CENTER);
        rogStrixButton.setVerticalTextPosition(JButton.BOTTOM);
        rogStrixButton.setIconTextGap(-2);
        rogStrixButton.setFocusable(false);
        rogStrixLabel.setBounds(240, 10, 25, 30);
        rogStrixLabel.setBackground(Color.white);
        rogStrixLabel.setOpaque(true);
        rogStrixLabel.setFont(new Font("Arial", Font.BOLD, 20));


        laptopPanel.add(rogStrixLabel);
        laptopPanel.add(ideaPadLabel);
        laptopPanel.add(asusTUFLabel);
        laptopPanel.add(acerNitroLabel);

        rogStrixButton.addActionListener(new ActionListener() {
            private int clicked = 0;
            private int totalSum;

            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = rogPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                rogStrixLabel.setText(String.valueOf(clicked));
                rogStrix = "|Rog Strix";
                items.setRogStrix(rogStrix + " " + clicked + " " + totalSum);

            }

        });


        JButton ideaPadButton = new JButton();
        ideaPadButton.setFocusable(false);
        ImageIcon ideaPadImage = new ImageIcon("ideapad.jpg");
        ideaPadButton.setIcon(ideaPadImage);
        ideaPadButton.setBounds(10, 195, 220, 180);
        ideaPadButton.setBackground(Color.white);
        ideaPadButton.setOpaque(true);
        ideaPadButton.setText("IdeaPad " + ideaPadPrice + " Лв.");
        ideaPadButton.setHorizontalTextPosition(JButton.CENTER);
        ideaPadButton.setVerticalTextPosition(JButton.BOTTOM);
        ideaPadButton.setIconTextGap(-2);
        ideaPadButton.setFocusable(false);
        ideaPadLabel.setBounds(240, 200, 25, 30);
        ideaPadLabel.setBackground(Color.white);
        ideaPadLabel.setOpaque(true);
        ideaPadLabel.setFont(new Font("Arial", Font.BOLD, 20));

        ideaPadButton.addActionListener(new ActionListener() {
            private int clicked = 0;
            private int totalSum;

            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = ideaPadPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                ideaPadLabel.setText(String.valueOf(clicked));
                ideaPad = "|ideaPad ";
                items.setIdeaPad(ideaPad + " " + clicked + " " + totalSum);


            }
        });

        JButton acerNitroButton = new JButton();
        acerNitroButton.setFocusable(false);
        ImageIcon nitro5Image = new ImageIcon("nitro5.jpg");
        acerNitroButton.setIcon(nitro5Image);
        acerNitroButton.setBounds(10, 385, 220, 180);
        acerNitroButton.setBackground(Color.white);
        acerNitroButton.setOpaque(true);
        acerNitroButton.setText("Acer Nitro 5 " + acerNitro5Price+ " Лв.");
        acerNitroButton.setHorizontalTextPosition(JButton.CENTER);
        acerNitroButton.setVerticalTextPosition(JButton.BOTTOM);
        acerNitroButton.setIconTextGap(-2);
        acerNitroButton.setFocusable(false);
        acerNitroLabel.setBounds(240, 390, 25, 30);
        acerNitroLabel.setBackground(Color.white);
        acerNitroLabel.setOpaque(true);

        acerNitroLabel.setFont(new Font("Arial", Font.BOLD, 20));

        acerNitroButton.addActionListener(new ActionListener() {
            private int clicked = 0;
            private int totalSum;

            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = acerNitro5Price * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                acerNitroLabel.setText(String.valueOf(clicked));
                acerNitro5 = "|Acer Nitro ";
                items.setAcerNitro(acerNitro5 + " " + clicked + " " + totalSum);
            }
        });

        JButton asusTUFButton = new JButton();
        asusTUFButton.setFocusable(false);
        ImageIcon asusTUFImage = new ImageIcon("asusTUF.jpg");
        asusTUFButton.setIcon(asusTUFImage);
        asusTUFButton.setBounds(10, 575, 220, 180);
        asusTUFButton.setBackground(Color.white);
        asusTUFButton.setOpaque(true);
        asusTUFButton.setText("Asus TUF" + asusTUFPrice + " Лв.");
        asusTUFButton.setHorizontalTextPosition(JButton.CENTER);
        asusTUFButton.setVerticalTextPosition(JButton.BOTTOM);
        asusTUFButton.setIconTextGap(-2);
        asusTUFButton.setFocusable(false);

        asusTUFLabel.setBounds(240, 580, 25, 30);
        asusTUFLabel.setBackground(Color.white);
        asusTUFLabel.setOpaque(true);
        asusTUFLabel.setFont(new Font("Arial", Font.BOLD, 20));

        asusTUFButton.addActionListener(new ActionListener() {
            private int clicked = 0;
            private int totalSum;

            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = asusTUFPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                asusTUFLabel.setText(String.valueOf(clicked));
                asusTUF = "|AsusTUF ";
                items.setAsusTuf(asusTUF + " " + clicked + " " + totalSum);
            }
        });
        cartWindow.setSize(300, 300);
        cartWindow.setLayout(null);
        JLabel paymentMethod = new JLabel("С какво искате да платите");
        paymentMethod.setBounds(20,10,200,20);
        cartWindow.add(paymentMethod);
        cartInfo.setBounds(0, 0, 300, 200);
        payPal.setBounds(10, 200, 100, 20);
        debitCard.setBounds(170, 200, 100, 20);


        cartWindow.add(payPal);
        payPal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(allItems);
                try {
                    writer.append(allItems.toString());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                allItems.clear();
                cartWindow.setVisible(false);
                JOptionPane.showMessageDialog(null, "Благодаря че пазарувахте при нас");
                System.exit(0);
            }
        });
        cartWindow.add(debitCard);
        debitCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(allItems);
                try {
                    writer.write(allItems.toString());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                allItems.clear();
                cartWindow.setVisible(false);
                JOptionPane.showMessageDialog(null, "Благодаря че пазарувахте при нас");
                System.exit(0);
            }
        });
        cartWindow.add(cartInfo);

        cartWindow.setVisible(false);


        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allItems.add(items);
                System.out.println(allItems);
                cartWindow.setVisible(true);

            }
        });



        laptopPanel.add(rogStrixButton);
        laptopPanel.add(ideaPadButton);
        laptopPanel.add(acerNitroButton);
        laptopPanel.add(asusTUFButton);
        //Панел с телефони
        smartPhonePanel.setBounds(250, 0, 550, 800);
        smartPhonePanel.setBackground(new Color(225, 198, 153));
        smartPhonePanel.setLayout(null);

        JButton redmi11ProButton = new JButton();
        redmi11ProButton.setBounds(10, 5, 220, 180);
        redmi11ProButton.setText("Redmi Note 11" + " "+redmiNote11Price+" Лв.");
        redmiNote11Label.setBounds(240, 580, 25, 30);
        redmi11ProButton.setFocusable(false);
        redmi11ProButton.setIcon(redmiNote11Icon);
        redmi11ProButton.setBackground(Color.white);
        redmi11ProButton.setHorizontalTextPosition(JButton.CENTER);
        redmi11ProButton.setVerticalTextPosition(JButton.BOTTOM);
        redmi11ProButton.setIconTextGap(-2);
        redmiNote11Label.setBounds(240, 10, 25, 30);
        redmiNote11Label.setBackground(Color.white);
        redmiNote11Label.setOpaque(true);
        redmiNote11Label.setFont(new Font("Arial", Font.BOLD, 20));
        redmi11ProButton.addActionListener(new ActionListener() {
            private int clicked=0;
            private int totalSum;
            @Override

            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = redmiNote11Price * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                redmiNote11Label.setText(String.valueOf(clicked));
                redmiNote11 = "|Redmi Note 11 ";
                items.setRedmiNote11(redmiNote11 + " " + clicked + " " + totalSum);
            }
        });
        iphone14Button.setBounds(10, 195, 220, 180);
        iphone14Button.setText("Iphone 14" + " "+iphone14Price+" Лв.");
        iphone14Button.setFocusable(false);

        iphone14Button.setIcon(iphone14Icon);
        iphone14Button.setBackground(Color.white);
        iphone14Button.setHorizontalTextPosition(JButton.CENTER);
        iphone14Button.setVerticalTextPosition(JButton.BOTTOM);
        iphone14Button.setIconTextGap(-2);
        iphone14Label.setBounds(240, 200, 25, 30);
        iphone14Label.setBackground(Color.white);
        iphone14Label.setOpaque(true);
        iphone14Label.setFont(new Font("Arial", Font.BOLD, 20));

        iphone14Button.addActionListener(new ActionListener() {
            private int clicked=0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = iphone14Price * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                iphone14Label.setText(String.valueOf(clicked));
                iphone14 = "|Iphone14 ";
                items.setIphone14(iphone14 + " " + clicked + " " + totalSum);
            }
        });
        huaweiP40Button.setBounds(10, 385, 220, 180);
        huaweiP40Button.setText("Huawei P40" + " "+huaweiP40Price+" Лв.");
        huaweiP40Button.setFocusable(false);
        huaweiP40Button.setIcon(huaweiP40Icon);
        huaweiP40Button.setBackground(Color.white);
        huaweiP40Button.setHorizontalTextPosition(JButton.CENTER);
        huaweiP40Button.setVerticalTextPosition(JButton.BOTTOM);
        huaweiP40Button.setIconTextGap(-2);
        huaweiP40Label.setBounds(240, 390, 25, 30);
        huaweiP40Label.setBackground(Color.white);
        huaweiP40Label.setOpaque(true);
        huaweiP40Label.setFont(new Font("Arial", Font.BOLD, 20));
        huaweiP40Button.addActionListener(new ActionListener() {
            private int clicked=0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = huaweiP40Price * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                huaweiP40Label.setText(String.valueOf(clicked));
                huaweiP40 = "|Huawei P40 ";
                items.setHuaweiP40(huaweiP40 + " " + clicked + " " + totalSum);
            }
        });
        galaxyS20Button.setBounds(10, 575, 220, 180);
        galaxyS20Button.setText("Galaxy S20" + " "+galaxyS20Price+" Лв.");
        galaxyS20Button.setFocusable(false);
        galaxyS20Button.setIcon(galaxyS20Icon);
        galaxyS20Button.setHorizontalTextPosition(JButton.CENTER);
        galaxyS20Button.setVerticalTextPosition(JButton.BOTTOM);
        galaxyS20Button.setIconTextGap(-2);
        galaxyS20Label.setBounds(240, 580, 25, 30);
        galaxyS20Label.setBackground(Color.white);
        galaxyS20Label.setOpaque(true);
        galaxyS20Label.setFont(new Font("Arial", Font.BOLD, 20));
        galaxyS20Button.addActionListener(new ActionListener() {
            private int clicked =0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {

                clicked++;
                totalSum = galaxyS20Price * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                galaxyS20Label.setText(String.valueOf(clicked));
                galaxyS20 = "|Galaxy S20 ";
                items.setGalaxyS20(galaxyS20 + " " + clicked + " " + totalSum);
            }
        });
        smartPhonePanel.add(redmi11ProButton);
        smartPhonePanel.add(redmiNote11Label);
        smartPhonePanel.add(iphone14Button);
        smartPhonePanel.add(iphone14Label);
        smartPhonePanel.add(huaweiP40Button);
        smartPhonePanel.add(huaweiP40Label);
        smartPhonePanel.add(galaxyS20Button);
        smartPhonePanel.add(galaxyS20Label);
        //Панел С Дрехиь

        clothesPanel.setBounds(250,0,550,800);
        clothesPanel.setBackground(new Color(225, 198, 153));
        clothesPanel.setLayout(null);

        sweatPantsButton.setBounds(10,5,200,180);
        sweatPantsButton.setText("SweatPants "+sweatPantsPrice+"Лв.");
        sweatPantsButton.setFocusable(false);
        sweatPantsLabel.setBounds(240, 10, 25, 30);
        sweatPantsLabel.setBackground(Color.white);
        sweatPantsLabel.setOpaque(true);
        sweatPantsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        sweatPantsButton.addActionListener(new ActionListener() {
            private int clicked=0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked++;
                totalSum = sweatPantsPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                sweatPantsLabel.setText(String.valueOf(clicked));
                sweatPants = "|SweatPants ";
                items.setSweatPants(sweatPants + " " + clicked + " " + totalSum);
            }
        });
        clothesPanel.add(sweatPantsButton);
        clothesPanel.add(sweatPantsLabel);

        denimButton.setBounds(10,195,200,180);
        denimButton.setFocusable(false);
        denimButton.setText("Denim "+denimPrice+"Лв");
        denimLabel.setBounds(240, 200, 25, 30);
        denimLabel.setBackground(Color.white);
        denimLabel.setOpaque(true);
        denimLabel.setFont(new Font("Arial", Font.BOLD, 20));
        denimButton.addActionListener(new ActionListener() {
            private int clicked =0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked++;
                totalSum = denimPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                denimLabel.setText(String.valueOf(clicked));
                denim = "|Denim ";
                items.setDenim(denim + " " + clicked + " " + totalSum);
            }
        });
        clothesPanel.add(denimButton);
        clothesPanel.add(denimLabel);

        shortDenimButton.setBounds(10,385,200,180);
        shortDenimButton.setFocusable(false);
        shortDenimButton.setText("ShorDenim "+ shortDenimPrice+"Лв");
        shortDenimLabel.setBounds(240, 390, 25, 30);
        shortDenimLabel.setBackground(Color.white);
        shortDenimLabel.setOpaque(true);
        shortDenimLabel.setFont(new Font("Arial", Font.BOLD, 20));
        shortDenimButton.addActionListener(new ActionListener() {
            private int clicked=0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked++;
                totalSum = shortDenimPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                shortDenimLabel.setText(String.valueOf(clicked));
                shortDenim = "|SweatPants ";
                items.setShortDenim(shortDenim + " " + clicked + " " + totalSum);
            }
        });
        clothesPanel.add(shortDenimButton);
        clothesPanel.add(shortDenimLabel);

        chinosButton.setBounds(10, 575, 200, 180);
        chinosButton.setFocusable(false);
        chinosButton.setText("Chinos "+chinosPrice+"Лв");
        chinosLabel.setBounds(240, 580, 25, 30);
        chinosLabel.setBackground(Color.white);
        chinosLabel.setOpaque(true);
        chinosLabel.setFont(new Font("Arial", Font.BOLD, 20));
        chinosButton.addActionListener(new ActionListener() {
            private int clicked=0;
            private int totalSum;
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked++;
                totalSum = chinosPrice * clicked;
                System.out.println(clicked);
                System.out.println(totalSum);
                chinosLabel.setText(String.valueOf(clicked));
                chinos = "|Chinos ";
                items.setChinos(chinos + " " + clicked + " " + totalSum);
            }
        });
        clothesPanel.add(chinosButton);
        clothesPanel.add(chinosLabel);



        layeredPane.add(treePanel, JLayeredPane.DRAG_LAYER);
        layeredPane.add(homePanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(laptopPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(smartPhonePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(clothesPanel,JLayeredPane.DEFAULT_LAYER);


    }
}






