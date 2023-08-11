import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JApplet implements ActionListener {
   // constant variables for status of game
   final int WON = 0, LOST = 1, CONTINUE = 2;  

   // other variables used in program
   boolean firstRoll = true;   // true if first roll
   int sumOfDice = 0;          // sum of the dice
   int myPoint = 0;   // point if no win/loss on first roll
   int gameStatus = CONTINUE;  // game not over yet

   // graphical user interface components 
   JLabel die1Label, die2Label, sumLabel, pointLabel;
   JTextField firstDie, secondDie, sum, point;
   JButton roll;

   // setup graphical user interface components
   public void init()
   {
	// 取得 ContentPane 物件且要求系統自動設定排列方式
      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

	// 標示 (Label) 及 輸入框 (Edit field)
	// 1. 生成物件 2. 加入 container 中
      die1Label = new JLabel( "Die 1" );
      c.add( die1Label );

	// 1.生成物件 2.多設定一個屬性 2.加入 container 中
      firstDie = new JTextField( 5 );
      firstDie.setEditable( false );
      c.add( firstDie );

      die2Label = new JLabel( "Die 2" );
      c.add( die2Label );
      secondDie = new JTextField( 5 );
      secondDie.setEditable( false );
      c.add( secondDie );

      sumLabel = new JLabel( "Sum is" );
      c.add( sumLabel );
      sum = new JTextField( 5 );
      sum.setEditable( false );
      c.add( sum );

      pointLabel = new JLabel( "Point is" );
      c.add( pointLabel );
      point = new JTextField( 5 );
      point.setEditable( false );
      c.add( point );

	// 按鈕
	// 1.生成物件 2.多設一個屬性 3.加入 container
      roll = new JButton( "Roll Dice" );
      roll.addActionListener( this );
      c.add( roll );
   }

   // call method play when button is pressed
   public void actionPerformed( ActionEvent e )
   {
      play();
   }

   // process one roll of the dice
   public void play()
   {
      if ( firstRoll ) {             // 頭一遭否 ?
         sumOfDice = rollDice();        
   
         switch ( sumOfDice ) {
            case 7: case 11:         // 7,11 所以我 (玩家) 贏了
               gameStatus = WON;
               point.setText( "" );  // clear point text field
               break;
            case 2: case 3: case 12: // 我 (玩家) 輸了
               gameStatus = LOST;
               point.setText( "" );  // clear point text field
               break;
            default:                 // remember point
               gameStatus = CONTINUE;
               myPoint = sumOfDice;  // 全體變數 myPoint 記住這個值	
               point.setText( Integer.toString( myPoint ) );
               firstRoll = false;
               break;
         }
      }
      else { // 不是第一次了 ! 
         sumOfDice = rollDice();
      
         if ( sumOfDice == myPoint )    // win by making point
            gameStatus = WON;
         else
            if ( sumOfDice == 7 )       // lose by rolling 7
               gameStatus = LOST;
      }

	// 把提醒玩家的事放在 status 的上
      switch ( gameStatus ) {
		case CONTINUE:
			showStatus( "Roll again." ); 
			break;
		case LOST:
			showStatus( "Player loses. " + "Click Roll Dice to play again." );
     			firstRoll = true;
			break;
		case WON:
			showStatus( "Player wins. " + "Click Roll Dice to play again." );
     			firstRoll = true;
			break;
		default:
			break;
     }
   }
   
   // roll the dice
   public int rollDice()
   {
      int die1, die2, workSum;   

      die1 = 1 + ( int ) ( Math.random() * 6 );
      die2 = 1 + ( int ) ( Math.random() * 6 );
      workSum = die1 + die2;

      firstDie.setText( Integer.toString( die1 ) );
      secondDie.setText( Integer.toString( die2 ) );
      sum.setText( Integer.toString( workSum ) );

      return workSum;
   }
}
