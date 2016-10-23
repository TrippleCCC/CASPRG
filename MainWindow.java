import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	public MainWindow() {
		super("CASPRG");
		
		setSize(1500, 1500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel forButtons = new JPanel();
		JPanel forText = new JPanel();
		
		JLabel pOR = new JLabel("Which doucument would you like to create?");
		pOR.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		
		
		//Creates buttons to pick either Proposal or a reflection
		//Asks the user to decide
		JButton pr = new JButton("Proposal");
		JButton r = new JButton("Reflection");
		
		pr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//r.setVisible(false);
				//pr.setVisible(false);
				//pOR.setVisible(false);
				forButtons.setVisible(false);
				forText.setVisible(false);
				
				beginProposal();
				
				
			}
		}
		);
		
		forButtons.add(pr);
		forButtons.add(r);
		
		forText.add(pOR);
		
		
		add(forButtons, BorderLayout.SOUTH);
		add(forText, BorderLayout.NORTH);
		
		
		
	}
	
	
	public int qn = 1; 
	public static String[] cAnswers = new String[12];
	
	public void beginProposal()
	{
		JPanel qText = new JPanel();
		JPanel qAnswerArea = new JPanel();
		JPanel submitArea = new JPanel();
		qText.setVisible(true);
		qAnswerArea.setVisible(true);
		submitArea.setVisible(true);
		
		
		String[] questions;
		questions = new String[12];
		questions[0] = "1. Give your CAS activity a descriptive title and date.";
		questions[1] = "2. Describe your idea in detail, including your roles and responsibilities.";
		questions[2] = "3. Are you collaborating with anyone? Please list their names.";
		questions[3] = "4. Is this experience Creativity, Activity, Service or multiple? Explain.";
		questions[4] = "5. Predict which of the 7 learning outcomes you will meet. (see CAS guide)";
		questions[5] = "6. What, specifically, do you hope to accomplish?";
		questions[6] = "7. Determine the steps necessary to accomplish your goals and give yourself an approximate deadline.";
		questions[7] = "8. Determine where you can go for assistance, advice, and information.  (people or resources)";
		questions[8] = "9. Who will supervise this CAS experience?  (review guidelines if necessary)";
		questions[9] = "10. Are there any risks involved with this experience?  Explain.";
		questions[10] = "11. How will you document your project?  (journals, spreadsheets, photos, videos, feedback from others, etc.)";
		
		//String[] bAnswers;
		//bAnswers = new String[11];
		
		//this label will hold the current question
		//qAnswer is the area where the user will type the answer
		JLabel question = new JLabel(questions[qn - 1]);
		question.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		JTextField qAnswer= new JTextField("Type answer here");
		qAnswer.setBounds(0, 0, 100, 300);
		qAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JButton okButton = new JButton("OK");
		//this is for the current question number
		//the array stores the answers of the questions
		
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(qAnswer.getText().equals("Type answer here"))
					cAnswers[qn - 1] = "This is required";
				else
					cAnswers[qn - 1] = qAnswer.getText();
				
				qn++;
				
				question.setText(questions[qn - 1]);
				//getAnswer(cAnswers, bAnswers);
				qAnswer.setText("Type answer here");
				
				if(qn == 12)
				{
					//ends the proposal program and goes to the final screen
					qText.setVisible(false);
					qAnswerArea.setVisible(false);
					submitArea.setVisible(false);
					finalScreen();
				}
				
			}
		});
		
		
		
		add(qText, BorderLayout.NORTH);
		add(qAnswerArea, BorderLayout.CENTER);
		add(submitArea, BorderLayout.SOUTH);
		qText.add(question);
		qAnswerArea.add(qAnswer, BorderLayout.CENTER);
		submitArea.add(okButton);
		
			
		
	}
	
	public void  getAnswer(String[] a, String[] b)
	{
		a = b;
	}
	
	public void finalScreen()
	{
		JPanel document = new JPanel();
		JPanel bottomNote = new JPanel();
		JTextArea fullDocument = new JTextArea("1. Give your CAS activity a descriptive title and date.\n" 
												+ cAnswers[0] + "\n"
												+ "2. Describe your idea in detail, including your roles and responsibilities.\n"
												+ cAnswers[1] + "\n"
												+ "3. Are you collaborating with anyone?  Please list their names.\n"
												+ cAnswers[2] + "\n"
												+ "4. Is this experience Creativity, Activity, Service, or multiple?  Explain.\n"
												+ cAnswers[3] + "\n"
												+ "5. Predict which of the 7 learning outcomes you will meet. (see CAS guide)\n"
												+ cAnswers[4] + "\n"
												+ "6. What, specifically, do you hope to accomplish?\n"
												+ cAnswers[5] + "\n"
												+ "7. Determine the steps necessary to accomplish your goals and give yourself an approximate deadline.\n"
												+ cAnswers[6] + "\n"
												+ "8. Determine where you can go for assistance, advice, and information.  (people or resources)\n"
												+ cAnswers[7] + "\n"
												+ "9. Who will supervise this CAS experience?  (review guidelines if necessary)\n"
												+ cAnswers[8] + "\n"
												+ "10. Are there any risks involved with this experience?  Explain.\n"
												+ cAnswers[9] + "\n"
												+ "11. How will you document your project?  (journals, spreadsheets, photos, videos, feedback from others, etc.)\n"
												+ cAnswers[10] + "\n");
		fullDocument.setFont(new Font("Georgia", Font.PLAIN, 25));
		
		JLabel note = new JLabel("You can edit your full proposal here. When you are done you can copy and paste the proposal into ManageBac. Make sure to fill in required areas.");
		note.setFont(new Font("New Times Roman", Font.PLAIN, 22));
		
		add(document, BorderLayout.NORTH);
		add(bottomNote, BorderLayout.SOUTH);
		document.add(fullDocument);
		bottomNote.add(note);
		
	}

}
