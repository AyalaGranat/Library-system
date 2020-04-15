
package Gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.omg.CORBA.PUBLIC_MEMBER;

import Controller.MainClass;
import Exceptions.CollectionNotExistException;
import Exceptions.ReaderNotExistException;
import Exceptions.itemNotExistException;
import Model.ArithmeticMean;
import Model.Author;
import Model.Book;
import Model.Encyclopedia;
import Model.Library;
import Model.Magazine;
import Model.Paper;
import Model.Reader;
import Utils.AcademicBook;
import Utils.BookSize;
import Utils.PaperValue;
import Utils.Topic;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IllegalFormatCodePointException;
import java.util.Set;

import javax.print.attribute.standard.MediaName;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JTextPane;
import javax.swing.JList;

public class UserGui extends JFrame implements ActionListener{
	private JList list;
	private JLabel background;
	private JMenuItem magazinePapers; 
	private JMenuItem encyclopediaBooks;
	private JMenuItem encyclopediaTopics;
	private JMenuItem magazineTopics;
	private JMenuItem encyclopediaAuthors;
	private JMenuItem magazineAuthros;
	private JButton save;
	//AHBH,H
	private ImageIcon image;
	JButton choosepicButton;
	private Icon pIcon;
	JLabel picJLabel;
	//BUUTONS
	private JButton buttons[];
	private final String nameButton[]= {"best book","best paper","k best books","k best papers","k best readers",
			"k best authors","topic best k books","topic best k papers","author best k books","author best k papers"};
	JLabel JlabelUser; //LABEL FOR USER

	public UserGui(String user) {
		super("Gui User");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				String wantSave[]= {"yes","no"};
				int choice=JOptionPane.showOptionDialog(getContentPane(), "Do you want to save?", "Online Examination System", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,wantSave,wantSave[1] );
				if(choice==0) {
					MainClass.librarySys.serialize(MainClass.librarySys);
					System.exit(0);
				}
			}
		});


		JlabelUser= new JLabel("New label");
		JlabelUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		setJMenuBar(menuBar);

		//JPANEL LAYOUT
		save=new JButton("save");
		save.setSize(50, 50);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainClass.librarySys.serialize(MainClass.librarySys);

			}
		});
		JLabel picJLabel=new JLabel("your pic");
		JButton button=new JButton("RETURN TO LOGIN");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login login=new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setSize(500, 500);
				login.setVisible(true);
				setVisible(false);
				dispose();

			}
		});

		JPanel jpanelbu=new JPanel();
		jpanelbu.setVisible(true);
		getContentPane().add(jpanelbu);
		getContentPane().add(JlabelUser);
		jpanelbu.add(picJLabel);
		jpanelbu.add(button);
		jpanelbu.add(save);


		//MAIN MENU 
		JMenu mnNewMenu = new JMenu("New menu");
		JMenu mnNewMenu_1 = new JMenu("New menu");
		JMenu mnNewMenu_2=new JMenu("Encyclopedia and Magazine ");
		JMenu mnNewMenu_3=new JMenu("Recomander");


		//add and remove 
		JMenuItem mntmAddReader = new JMenuItem("Add Reader"); //for add reader
		mntmAddReader.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Add addReader=new Add("reader");
				addReader.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addReader.setSize(450, 400);
				addReader.setVisible(true);
				//	setVisible(false);
			}


		});
		JMenuItem mntmRemoveReader = new JMenuItem("Remove Reader");
		JMenuItem mntmAddAuthor = new JMenuItem("Add Author");
		JMenuItem mntmremoveAuthor = new JMenuItem("Remove Author");
		JMenuItem mntmAddItem = new JMenuItem("Add Item");
		JMenuItem mntmRemoveItem = new JMenuItem("Remove Item");
		JMenuItem mntmAddCollection = new JMenuItem("Add Collection");
		JMenuItem mntmRemoveCollection = new JMenuItem("Remove Collection");
		JMenuItem mntmAddCollectionItem = new JMenuItem("Add Collection to Item");
		JMenuItem mntmReadItem = new JMenuItem("Read Item ");
		JMenuItem mntmMakeReview = new JMenuItem("Make Review ");
		JMenuItem mntmGetReviews = new JMenuItem("Get reviews by item ");

		//recommend
		JMenuItem mntmRecommendBookByTopic = new JMenuItem("Reccomand Book By Topic");
		JMenuItem mntmRecommendPaperByTopic = new JMenuItem("Reccomand Paper By Topic");
		JMenuItem mntmRecommendBookByAuthor = new JMenuItem("Recommend Book By Author");
		JMenuItem mntmRecommendPaperByAuthor = new JMenuItem("RecommendPaperByAuthor");


		mnNewMenu_3.add(mntmRecommendBookByTopic);
		mnNewMenu_3.add(mntmRecommendPaperByTopic);
		mnNewMenu_3.add(mntmRecommendBookByAuthor);
		mnNewMenu_3.add(mntmRecommendPaperByAuthor);

		magazinePapers = new JMenuItem("Papaers by Magazine ");
		magazinePapers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PapersByMagazine();

			}
		});

		encyclopediaBooks = new JMenuItem("Books by Encyclopeadia");
		encyclopediaBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BooksByEncyclopedia();
			}


		});




		encyclopediaTopics = new JMenuItem("Topics by Encyclopedia");
		encyclopediaTopics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EncyclopediaTopics();
			}
		});


		magazineTopics= new JMenuItem("Topics by Magazine ");
		magazineTopics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MagazineTopics();	

			}
		});



		magazineAuthros = new JMenuItem("Author by Magazine");
		magazineAuthros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MagazineAuthors();

			}
		});



		encyclopediaAuthors = new JMenuItem("Author by Encyclopedia");
		encyclopediaAuthors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EncyclopediaAuthors();		 

			}
		});




		//ADMIN

		if(user.equals("ADMIN")){
			JlabelUser.setText("WELCOME "+user);


			//menu 
			menuBar.add(mnNewMenu);
			menuBar.add(mnNewMenu_1);
			menuBar.add(mnNewMenu_2);
			mnNewMenu.setText("Add and Remove");
			menuBar.add(mnNewMenu_1);
			mnNewMenu_1.setText("Get");
			menuBar.add(mnNewMenu_3);

			//menu item only for admin for get 
			JMenuItem getPapers = new JMenuItem("get Papers");
			JMenuItem getBooks = new JMenuItem("get Books");
			JMenuItem getAuthors = new JMenuItem("get Authors");
			JMenuItem getReaders = new JMenuItem("get Readers");
			JMenuItem getMagazines = new JMenuItem("get Magazines");
			JMenuItem getEncyclopedies = new JMenuItem("get Encyclopedies");
			{
				getPapers.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Library.getInstance().getPapers().isEmpty())
							JOptionPane.showMessageDialog(getContentPane(), " no papers in library ");
						else {
							list= new JList();
							list.setListData(Library.getInstance().getPapers().toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}

					}
				});

				getBooks.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(Library.getInstance().getBooks().isEmpty())
							JOptionPane.showMessageDialog(getContentPane(), " no books in library ");
						else {
							list= new JList();
							list.setListData(Library.getInstance().getBooks().toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
							
						}

					}
				});

				getAuthors.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(Library.getInstance().getAuthors().isEmpty())
							JOptionPane.showMessageDialog(getContentPane(), " no authors in library ");
						else {
							list= new JList();
							list.setListData(Library.getInstance().getAuthors().toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}
					}
				});

				getReaders.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(Library.getInstance().getReaders().isEmpty())
							JOptionPane.showMessageDialog(getContentPane(), " no readers in library ");
						else {
							list= new JList();
							list.setListData(Library.getInstance().getReaders().toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}

					}
				});

				getMagazines.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(Library.getInstance().getMagazines().isEmpty())
							JOptionPane.showMessageDialog(getContentPane(), " no magazines in library ");
						else {
							list= new JList();
							list.setListData(Library.getInstance().getMagazines().toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}

					}
				});

				getEncyclopedies.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(Library.getInstance().getEncyclopedias().isEmpty())
							JOptionPane.showMessageDialog(getContentPane(), " no Encyclopedias in library ");
						else {
							list= new JList();
							list.setListData(Library.getInstance().getEncyclopedias().toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}

					}
				});


				mnNewMenu_1.add(getPapers);
				mnNewMenu_1.add(getBooks);
				mnNewMenu_1.add(getAuthors);
				mnNewMenu_1.add(getReaders);
				mnNewMenu_1.add(getMagazines);
				mnNewMenu_1.add(getEncyclopedies);

				mntmRecommendBookByTopic.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						RecomanderGui reco=new RecomanderGui("topicBook");
						reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						reco.setSize(400, 400);
						reco.setVisible(true);


					}
				} );

				mntmRecommendPaperByTopic.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						RecomanderGui reco=new RecomanderGui("topicPaper");
						reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						reco.setSize(400, 400);
						reco.setVisible(true);


					}
				});

				mntmRecommendBookByAuthor.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						RecomanderGui reco=new RecomanderGui("authorBook");
						reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						reco.setSize(400, 400);
						reco.setVisible(true);


					}
				});

				mntmRecommendPaperByAuthor.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						RecomanderGui reco=new RecomanderGui("authorPaper");
						reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						reco.setSize(450, 400);
						reco.setVisible(true);


					}
				});



				//add reader 
				mnNewMenu.add(mntmAddReader);

				mnNewMenu.add(mntmRemoveReader);
				mntmRemoveReader.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Remove removeReader=new Remove("reader");
						removeReader.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						removeReader.setSize(450, 400);
						removeReader.setVisible(true);

					}
				});


				//add author
				mnNewMenu.add(mntmAddAuthor);
				mntmAddAuthor.setText("Add Author");
				mntmAddAuthor.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Add addReader=new Add("author");
						addReader.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						addReader.setSize(450, 400);
						addReader.setVisible(true);
						//	setVisible(false);
					}


				});

				//only for Admin
				mnNewMenu.add(mntmremoveAuthor);
				mnNewMenu.add(mntmremoveAuthor);
				mntmremoveAuthor.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Remove removeReader=new Remove("author");
						removeReader.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						removeReader.setSize(450, 400);
						removeReader.setVisible(true);

					}
				});

				mnNewMenu.add(mntmAddItem); 
				mntmAddItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Add addItem= new Add("item");
						addItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						addItem.setSize(450, 400);
						addItem.setVisible(true);
						//	setVisible(false);
					}


				});


				mnNewMenu.add(mntmRemoveItem);
				mntmRemoveItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Remove removeitem=new Remove("item");
						removeitem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						removeitem.setSize(450, 350);
						removeitem.setVisible(true);
					}
				});
				mnNewMenu.add(mntmAddCollection); 
				mntmAddCollection.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Add addCollection=new Add("collection");
						addCollection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						addCollection.setSize(450, 350);
						addCollection.setVisible(true);

					}
				});
				mnNewMenu.add(mntmRemoveCollection);
				mntmRemoveCollection.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Remove removeCollection=new Remove("collection");
						removeCollection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						removeCollection.setSize(450, 350);
						removeCollection.setVisible(true);

					}
				});

				mnNewMenu.add(mntmAddCollectionItem);
				mntmAddCollectionItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Add addCollectionItem=new Add("itemToCollection");
						addCollectionItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						addCollectionItem.setSize(450,350);
						addCollectionItem.setVisible(true);

					}
				});
				mnNewMenu.add(mntmReadItem);
				mntmReadItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ReadItem readItem=new ReadItem();
						readItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						readItem.setSize(400, 400);
						readItem.setVisible(true);
					}
				});
				mnNewMenu.add(mntmMakeReview);
				mntmMakeReview.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						MakeReview makeReview= new MakeReview();
						makeReview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						makeReview.setSize(400, 400);
						makeReview.setVisible(true);

					}
				});
				
				mnNewMenu.add(mntmGetReviews);
				mntmGetReviews.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						GetReviews getReviews=new GetReviews();
						
						
					}
				});
				mnNewMenu_2.add(magazinePapers);
				mnNewMenu_2.add(encyclopediaBooks);
				mnNewMenu_2.add(encyclopediaTopics);
				mnNewMenu_2.add(magazineTopics);
				mnNewMenu_2.add(magazineAuthros);
				mnNewMenu_2.add(encyclopediaAuthors);



				getContentPane().setLayout(new GridLayout(6,2,10,10));
				buttons=new JButton[nameButton.length];
				for(int count=0;count<nameButton.length;count++) {
					buttons[count]=new JButton(nameButton[count]);
					getContentPane().add(buttons[count],BorderLayout.EAST);
					buttons[count].addActionListener(this);

				}

			}
		}

		//LIBRIAN
		else if(user.equals("LIBRIAN")) {
			JlabelUser.setText("WELCOME "+user);
			getContentPane().add(jpanelbu);

			menuBar.add(mnNewMenu);
			mnNewMenu.setText("Add and Get");
			mnNewMenu.add(mntmAddReader);


			mnNewMenu.add(magazinePapers);
			mnNewMenu.add(encyclopediaBooks);
			mnNewMenu.add(encyclopediaTopics);
			mnNewMenu.add(magazineTopics);
			mnNewMenu.add(magazineAuthros);
			mnNewMenu.add(encyclopediaAuthors);


			getContentPane().setLayout(new GridLayout(6,2,1,1));
			buttons=new JButton[nameButton.length];
			for(int count=0;count<nameButton.length;count++) {
				buttons[count]=new JButton(nameButton[count]);
				getContentPane().add(buttons[count],BorderLayout.EAST);
				buttons[count].addActionListener(this);
			}


		}

		//READER
		else  {
			for (Reader re: Library.getInstance().getReaders()) {		
				if((re.getFirstName()+" "+re.getLastName()).equals(user)) {
					getContentPane().setLayout(new BorderLayout());
					getContentPane().add(picJLabel);
					choosepicButton=new JButton("update your picture");
					picJLabel.add(choosepicButton);
					choosepicButton.setBounds(0,0, 200, 23);
					
					picJLabel.setBounds(0, 0, 110, 110);
					JlabelUser.setText("WELCOME "+user);
					JPanel jPanel=new JPanel();
					jPanel.add(JlabelUser);
					jPanel.add(jpanelbu);
					Reader thisReader;
					try {
						thisReader=Library.getInstance().getReaderByName(re.getFirstName(),re.getLastName());
					}
					catch (ReaderNotExistException e) {
						System.out.println("not exsist");
					}
					choosepicButton.addActionListener(new ActionListener() {
					
						@Override
						public void actionPerformed(ActionEvent e) {
						
							 JFileChooser chooser = new JFileChooser();
							    FileNameExtensionFilter filter = new FileNameExtensionFilter(
							        "JPG & GIF Images", "jpg", "gif");
							    chooser.setFileFilter(filter);
							    int returnVal = chooser.showOpenDialog(getParent());
							    if(returnVal == JFileChooser.APPROVE_OPTION) {
							    	String pathString= chooser.getSelectedFile().getPath();
							    	
							   
							       System.out.println("You chose to open this file: " +
							            chooser.getSelectedFile().getName());
							       System.out.println(pathString);
							       Icon newicopIcon=new ImageIcon(pathString);
							       picJLabel.setIcon(newicopIcon);
							       picJLabel.setVisible(true);
							       jPanel.add(picJLabel,BorderLayout.WEST);
							       picJLabel.setBounds(0,0 , 110, 110);
							       
							    }
								
						}
					});
				 
					//buttons
					getContentPane().add(jPanel,BorderLayout.NORTH);
					getContentPane().setLayout(new GridLayout(3,2,5,5));
					buttons=new JButton[nameButton.length];
					for(int count=6;count<nameButton.length;count++) {
						buttons[count]=new JButton(nameButton[count]);
						getContentPane().add(buttons[count],BorderLayout.CENTER);
						buttons[count].addActionListener(this);
					}


					menuBar.add(mnNewMenu);
					menuBar.add(mnNewMenu_3);
					mnNewMenu.setText("Menu");
					mnNewMenu.add(mntmReadItem);
					mntmReadItem.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ReadItem readItem=new ReadItem(re.getFirstName(),re.getLastName());
							readItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							readItem.setSize(400, 400);
							readItem.setVisible(true);
						}
					});
					mnNewMenu.add(mntmMakeReview);
					mntmMakeReview.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							MakeReview makeReview= new MakeReview(re.getFirstName(),re.getLastName());
							makeReview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							makeReview.setSize(400, 400);
							makeReview.setVisible(true);

						}
					});


					mntmRecommendBookByTopic.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							RecomanderGui reco=new RecomanderGui("topicBook",re.getFirstName(),re.getLastName());
							reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							reco.setSize(400, 400);
							reco.setVisible(true);


						}
					} );

					mntmRecommendPaperByTopic.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							RecomanderGui reco=new RecomanderGui("topicPaper",re.getFirstName(),re.getLastName());
							reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							reco.setSize(400, 400);
							reco.setVisible(true);


						}
					});

					mntmRecommendBookByAuthor.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							RecomanderGui reco=new RecomanderGui("authorBook",re.getFirstName(),re.getLastName());
							reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							reco.setSize(400, 400);
							reco.setVisible(true);


						}
					});

					mntmRecommendPaperByAuthor.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							RecomanderGui reco=new RecomanderGui("authorPaper",re.getFirstName(),re.getLastName());
							reco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							reco.setSize(400, 400);
							reco.setVisible(true);


						}
					});


				}
			}
			
		}
		

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("best book")) {
			BestBookOrPaper bestBookOrPaper=new BestBookOrPaper("book");
			bestBookOrPaper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			bestBookOrPaper.setSize(300, 300);
			bestBookOrPaper.setVisible(true);



		}
		else if(e.getActionCommand().equals("best paper")) {
			BestBookOrPaper bestBookOrPaper=new BestBookOrPaper("paper");
			bestBookOrPaper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			bestBookOrPaper.setSize(300, 300);
			bestBookOrPaper.setVisible(true);

		}
		else if(e.getActionCommand().equals("k best books")) {
			KBestBooksOrPapers kBestBooksOrPapers=new KBestBooksOrPapers("book");
			kBestBooksOrPapers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kBestBooksOrPapers.setSize(300, 300);
			kBestBooksOrPapers.setVisible(true);
		}
		else if(e.getActionCommand().equals("k best papers")) {
			KBestBooksOrPapers kBestBooksOrPapers=new KBestBooksOrPapers("paper");
			kBestBooksOrPapers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kBestBooksOrPapers.setSize(300, 300);
			kBestBooksOrPapers.setVisible(true);
		}
		else if(e.getActionCommand().equals("k best readers")) {
			KBestReadersOrAuthors kBestReadersOrAuthors=new KBestReadersOrAuthors("reader");
			kBestReadersOrAuthors.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kBestReadersOrAuthors.setSize(300, 300);
			kBestReadersOrAuthors.setVisible(true);
		}
		else if(e.getActionCommand().equals("k best authors")) {
			KBestReadersOrAuthors kBestReadersOrAuthors=new KBestReadersOrAuthors("author");
			kBestReadersOrAuthors.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kBestReadersOrAuthors.setSize(300, 300);
			kBestReadersOrAuthors.setVisible(true);
		}


		else if(e.getActionCommand().equals("topic best k books")) {
			bestKTopicBookOrPaper bestKTopicBookOrPapers=new bestKTopicBookOrPaper("book");
			bestKTopicBookOrPapers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			bestKTopicBookOrPapers.setSize(300, 300);
			bestKTopicBookOrPapers.setVisible(true);
		}
		else if(e.getActionCommand().equals("topic best k papers")) {
			bestKTopicBookOrPaper bestKTopicBookOrPapers=new bestKTopicBookOrPaper("paper");
			bestKTopicBookOrPapers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			bestKTopicBookOrPapers.setSize(300, 300);
			bestKTopicBookOrPapers.setVisible(true);
		}
		else if(e.getActionCommand().equals("author best k books")) {
			AuthorKbestBookOrPaper authorKbestBookOrPaperS=new AuthorKbestBookOrPaper("book");
			authorKbestBookOrPaperS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			authorKbestBookOrPaperS.setSize(300, 300);
			authorKbestBookOrPaperS.setVisible(true);
		}
		else if(e.getActionCommand().equals("author best k papers")) {
			AuthorKbestBookOrPaper authorKbestBookOrPaper=new AuthorKbestBookOrPaper("paper");
			authorKbestBookOrPaper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			authorKbestBookOrPaper.setSize(300, 300);
			authorKbestBookOrPaper.setVisible(true);
		}


	}
}
