import processing.core.*; 
import processing.xml.*; 

import gifAnimation.*; 

import gifAnimation.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Cookie_Attack_May_9 extends PApplet {

 /* Cookie Attack
 * Cookie Dough Productions
 * Game Programmer - Priscilla Yu
 * Production Manager - Angel Lei
 * Graphic Designer - Miranda Kuang
 *  
 * February 13, 2012
 */


Gif logoAnimation;
Gif menuAnimation;
Gif tutorialOne;
Gif tutorialTwo;
Gif tutorialThree;
Gif tutorialFour;

int gender;
PImage Female, Male, Duck, Bear, Panda;

PImage InstructionBackground, LevelBackground, GameBackground1, GameBackground2, WinnerBackground, GameOverBackgound, CreditBackground;
PImage Heart;
PImage Cookie1, Cookie2, Cookie3, Cookie4;
PImage Scientist, Monster1, Monster2, Monster3, Monster4, Monster5, Monster6, Monster7;

List<Cookies> cookies = new ArrayList<Cookies>();
List<Monsters> monsters = new ArrayList<Monsters>();

int screenNumber = 0;

public void setup()
{
  size (550, 650);
  smooth();
  
  logoAnimation = new Gif(this, "Cookie.gif");
  menuAnimation = new Gif(this, "menu.gif");
  tutorialOne   = new Gif(this, "lvl1turtorial.gif");
  tutorialTwo   = new Gif(this, "lvl2turtorial.gif");
  tutorialThree = new Gif(this, "lvl3turtorial.gif");
  tutorialFour  = new Gif(this, "lvl4turtorial.gif");
  
  InstructionBackground = loadImage("inst2.jpg");
  LevelBackground = loadImage("Levels1.jpg");
  GameBackground1 = loadImage("map2.png");
  GameBackground2 = loadImage("mapup.png");
  WinnerBackground = loadImage("winnerscreen.jpg");
  GameOverBackgound = loadImage("gameover.jpg");
  CreditBackground = loadImage("credit.jpg");
  
  Female = loadImage("girl.png");
  Male = loadImage("boy.png");
  Duck = loadImage("duck.png");
  Bear = loadImage("bear.png");
  Panda = loadImage("panda.png");
  
  Scientist = loadImage("scientist.png");
  Monster1 = loadImage("monster1.png");
  Monster2 = loadImage("monster2.png");
  Monster3 = loadImage("monster3.png");
  Monster4 = loadImage("monster4.png");
  Monster5 = loadImage("monster5.png");
  Monster6 = loadImage("monster6.png");
  Monster7 = loadImage("monster7.png");
  
  Cookie1 = loadImage("cookie1.png");
  Cookie2 = loadImage("cookie2.png");
  Cookie3 = loadImage("cookie3.png");
  Cookie4 = loadImage("cookie4.png");
  Heart = loadImage("Life.png");
  
}

public void draw()
{
  println(mouseX + "," + mouseY);
  background (255);
  if (screenNumber == 0) LogoScreen();
  if (screenNumber == 1) TitleScreen();
  if (screenNumber == 2) CharacterScreen();
  if (screenNumber == 3) InstructionsScreen();
  if (screenNumber == 4) LevelScreen();
  if (screenNumber == 5) PlayScreen();
  if (screenNumber == 6) GameOverScreen();
  if (screenNumber == 7) CreditScreen();
  
  if (screenNumber == 8) TutorialScreen();
  if (screenNumber == 9) WinnerScreen();
}




String textEnteredTop ="";
String textEnteredBottom = "";
int textY = 460;
boolean numerator=true;
boolean correct=true;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void Answer()
{
  stroke(0);
  strokeWeight(5);
  line (400, 475, 470, 475);
  fill(255);
  textSize(25);
  text (textEnteredTop, 400, 460);
  text (textEnteredBottom, 400, 500);

  if (numerator) line (470, 437, 470, 462); 
  else if (!numerator) line (470, 482, 470, 500);

  /*
  if (!correct)  
  {
    correct = true;
    LoseHealth += 20; 
  }*/
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void mouseClicked()
{
  if (mouseX>=370 && mouseX<=500 && mouseY>=430 && mouseY<=470) numerator = true;
  else if (mouseX>=370 && mouseX<=500 && mouseY>=477 && mouseY<=515) numerator = false;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void keyPressed()
{
  
  if (key == ' ')
   {
   if (numerator) numerator = false;
   else if (!numerator) numerator = true;
   }
   if (keyCode == UP) numerator = true;
   if (keyCode == DOWN) numerator = false;
   
  if (key == ENTER)
  { 
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    if (Level == 1)
    {
      if (QuestionNumber == 1)
      {
        if (textEnteredTop.equals("6") && textEnteredBottom.equals("7"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 2)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 3)
      {
        if (textEnteredTop.equals("8") && textEnteredBottom.equals("9"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 4)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("6"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 5)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("4"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 6)
      {
        if (textEnteredTop.equals("9") && textEnteredBottom.equals("10"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 7)
      {
        if (textEnteredTop.equals("7") && textEnteredBottom.equals("9"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 8)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("8"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 9)
      {
        if (textEnteredTop.equals("8") && textEnteredBottom.equals("15"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 10)
      {
        if (textEnteredTop.equals("13") && textEnteredBottom.equals("14"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 11)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("15"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 12)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("18"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 13)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 14)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("8"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 15)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("4"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 16)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("14"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 17)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("12"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 18)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("2"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 19)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("6"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 20)
      {
        if (textEnteredTop.equals("4") && textEnteredBottom.equals("15"))  NewQuestion();
        else correct = false;
      }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    else if (Level == 2)
    {
      if (QuestionNumber == 1)
      {
        if (textEnteredTop.equals("7") && textEnteredBottom.equals("36"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 2)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("14"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 3)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("18"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 4)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("16"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 5)
      {
        if (textEnteredTop.equals("22") && textEnteredBottom.equals("15"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 6)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("8"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 7)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("7"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 8)
      {
        if (textEnteredTop.equals("27") && textEnteredBottom.equals("16"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 9)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("12"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 10)
      {
        if (textEnteredTop.equals("20") && textEnteredBottom.equals("27"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 11)
      {
        if (textEnteredTop.equals("53") && textEnteredBottom.equals("60"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 12)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("12"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 13)
      {
        if (textEnteredTop.equals("17") && textEnteredBottom.equals("20"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 14)
      {
        if (textEnteredTop.equals("11") && textEnteredBottom.equals("18"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 15)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("6"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 16)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("3"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 17)
      {
        if (textEnteredTop.equals("11") && textEnteredBottom.equals("24"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 18)
      {
        if (textEnteredTop.equals("19") && textEnteredBottom.equals("45"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 19)
      {
        if (textEnteredTop.equals("11") && textEnteredBottom.equals("18"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 20)
      {
        if (textEnteredTop.equals("4") && textEnteredBottom.equals("3"))  NewQuestion();
        else correct = false;
      }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    else if (Level == 3)
    {
      if (QuestionNumber == 1)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("28"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 2)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("28"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 3)
      {
        if (textEnteredTop.equals("9") && textEnteredBottom.equals("20"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 4)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("35"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 5)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("35"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 6)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("6"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 7)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("14"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 8)
      {
        if (textEnteredTop.equals("4") && textEnteredBottom.equals("9"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 9)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 10)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("4"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 11)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("15"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 12)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("10"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 13)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 14)
      {
        if (textEnteredTop.equals("8") && textEnteredBottom.equals("15"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 15)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("10"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 16)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("6"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 17)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("21"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 18)
      {
        if (textEnteredTop.equals("10") && textEnteredBottom.equals("21"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 19)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("6"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 20)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("14"))  NewQuestion();
        else correct = false;
      }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    else if (Level == 4)
    {
      if (QuestionNumber == 1)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("2"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 2)
      {
        if (textEnteredTop.equals("4") && textEnteredBottom.equals("9"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 3)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("3"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 4)
      {
        if (textEnteredTop.equals("18") && textEnteredBottom.equals("7"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 5)
      {
        if (textEnteredTop.equals("16") && textEnteredBottom.equals("7"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 6)
      {
        if (textEnteredTop.equals("15") && textEnteredBottom.equals("7"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 7)
      {
        if (textEnteredTop.equals("4") && textEnteredBottom.equals("3"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 8)
      {
        if (textEnteredTop.equals("9") && textEnteredBottom.equals("10"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 9)
      {
        if (textEnteredTop.equals("8") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 10)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("8"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 11)
      {
        if (textEnteredTop.equals("7") && textEnteredBottom.equals("8"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 12)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("3"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 13)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("3"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 14)
      {
        if (textEnteredTop.equals("20") && textEnteredBottom.equals("7"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 15)
      {
        if (textEnteredTop.equals("3") && textEnteredBottom.equals("2"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 16)
      {
        if (textEnteredTop.equals("4") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 17)
      {
        if (textEnteredTop.equals("2") && textEnteredBottom.equals("5"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 18)
      {
        if (textEnteredTop.equals("5") && textEnteredBottom.equals("2"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 19)
      {
        if (textEnteredTop.equals("1") && textEnteredBottom.equals("2"))  NewQuestion();
        else correct = false;
      }
      if (QuestionNumber == 20)
      {
        if (textEnteredTop.equals("15") && textEnteredBottom.equals("16"))  NewQuestion();
        else correct = false;
      }
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  else 
  {
    if (key == DELETE || key == BACKSPACE)
    {
      if (numerator)
      {
        int stringLength = textEnteredTop.length();
        if (stringLength > 0) textEnteredTop = textEnteredTop.substring(0, stringLength-1);
      }
      else if (!numerator)
      {
        int stringLength = textEnteredBottom.length();
        if (stringLength > 0) textEnteredBottom = textEnteredBottom.substring(0, stringLength-1);
      }
    }
    else if (key=='0' || key =='1' || key=='2' || key=='3' || key=='4' || key=='5' || key=='6' || key=='7' || key=='8' || key=='9')
    {
      int stringLength1 = textEnteredTop.length();
      int stringLength2 = textEnteredBottom.length();
      if (numerator && stringLength1 < 4) textEnteredTop += key;
      else if (!numerator && stringLength2 < 4) textEnteredBottom += key;
    }
  }
}

class Cookies
{
  int x, y;
  int number = CookieSelect;
  
  Cookies(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public void show()
  {
    y -= 3;
    if (number == 1) image (Cookie1, x-25, y);
    if (number == 2) image (Cookie2, x-25, y);
    if (number == 3) image (Cookie3, x-25, y);
    if (number == 4) image (Cookie4, x-25, y);
  }
}

class Monsters
{
  float x, y;
  float x0 = random(135, 450);
  float y0 = random (100, 300);

  float speed = 0.5f;
  boolean goIn = false;
  boolean show;

  int number = MonsterNumber;

  Monsters(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public void show()
  {
    show = true;
    if (number == 1) image (Monster1, x-25, y);
    if (number == 2) image (Monster2, x-25, y);
    if (number == 3) image (Monster3, x-25, y);
    if (number == 4) image (Monster4, x-25, y);
    if (number == 5) image (Monster5, x-25, y);
    if (number == 6) image (Monster6, x-25, y);
    if (number == 7) image (Monster7, x-25, y);
  }
  public void move() 
  {
    if (!goIn)
    {
      if (x>120) x-= speed+0.5f;
      if (x<275 && x >200) call = true;
      else if (x<=120) goIn = true;
    }
    if (goIn)
    {
      if (y >= y0) 
      {
        y += speed/4;
        if (x <= x0) x += speed+0.5f;
        else y += speed;
      }
      else y += speed;
    }
    for (Iterator iterator = cookies.iterator(); iterator.hasNext();) 
    {
      Cookies s = (Cookies) iterator.next();
      if (dist(s.x, s.y - 20, x, y) < 90) 
      {
        iterator.remove();
        show = false;
      }
    }
  }
}

int Level = 1;

float lives = 3;
float LoseHealth;
int CookieNumber=0;
int CookieSelect=1;
int MonsterNumber;
boolean call=true; // <-for monsters

float x; // <- x Position for the avatars

boolean help = false;
int Pass = 3;

int targetX, targetY;
float UpdateCookieX, UpdateCookieY;
boolean DeleteCookie = false;

int score=0;

boolean initial=true;

int hitLight;
boolean lightOn = false;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void PlayScreen()
{
  background(GameBackground1);
  CheckMonster();
  outside();
  image(GameBackground2, 0, 0);
  CheckLife();
  CheckHealth();
  CheckScore();
  CheckCookie();
  Answer();
  Question();
  mouse();
  lighting();
  Help();
  initial = false;

  if (gender == 1) image(Female, x, 440);
  else if (gender == 2) image(Male, x, 440);
  else if (gender == 3) image (Duck, x, 440);
  else if (gender == 4) image (Bear, x, 440);
  else if (gender == 5) image (Panda, x, 460);
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void mouse()
{
  if (mouseY < 415)
  {
    if (CookieNumber > 0) stroke(2);
    else if (CookieNumber == 0)
    {
      noFill();
     stroke (255, 0, 0);
     fill(255, 0, 0);
     textSize(20);
     text ("Answer to get cookies", mouseX-100, mouseY-35); 
    }
    x = mouseX-75;
    noCursor();
    noFill();
   // stroke(2);
    ellipse (mouseX, mouseY, 50, 50);
    line (mouseX-30, mouseY, mouseX+30, mouseY); 
    line (mouseX, mouseY-30, mouseX, mouseY+30);
  }
  for (Iterator iterator = cookies.iterator(); iterator.hasNext();) 
  {
    Cookies s = (Cookies) iterator.next();
    s.show();
    UpdateCookieX = s.x;
    UpdateCookieY = s.y;
    if (DeleteCookie == true || s.y <120)
    {
      iterator.remove();
      //targetX = targetY = 0;
      DeleteCookie = false;
      UpdateCookieX = 0;
      UpdateCookieY = 0;
    }
    if (initial==true)
    {
      iterator.remove();
    }
  }
  if (mouseY >= 415)
  {
    cursor (ARROW); 
    x = 150;
  }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void mousePressed()
{
  if (mouseY<=407)
  {
    if (CookieNumber > 0)
    {
      //targetX = mouseX;
      //targetY = mouseY;
      CookieSelect = (int) random (1, 4);
      cookies.add(new Cookies(mouseX, 480));
      CookieNumber -= 1;
    }
  }
  if (mouseX>=475 && mouseX<=525 && mouseY>=525 && mouseY<=540)
  {
    if (Pass >0) 
    {
      QuestionNumber = (int) random (1, 11); 
      textEnteredTop ="";
      textEnteredBottom = "";
      numerator = true;
      Pass -= 1;
    }
  }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void CheckHealth()
{
  fill(255, 0, 0);
  noStroke();
  rect (235, 103, 200-LoseHealth, 15);
  if (LoseHealth >= 200) 
  {
    LoseHealth = 0;
    lives -= 1;
  }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void CheckLife()
{
  for (int i=0; i < lives; i=i+1)image (Heart, 475+i*25, 100);
  if (lives <= 0) screenNumber = 6;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void CheckCookie()
{
  image (Cookie4, 375, 413, 20, 20);
  textSize(20);
  fill(255);
  text("x", 405, 428);
  text(CookieNumber, 425, 430);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void CheckMonster()
{
  float callMonster = (int) random (1, 1000);
  if (call == true && callMonster <= 5) 
  {
    monsters.add(new Monsters(350, 2));
    MonsterNumber = (int) random (1, 8);
    call = false;
  }
  for (Iterator iterator = monsters.iterator(); iterator.hasNext();) 
  {
    Monsters s = (Monsters) iterator.next();
    s.show();
    s.move();
    //if (s.x < 200) call = true;
    if (s.y > 355)
    {
      hitLight = 100;
      iterator.remove();
      LoseHealth += 20;
    }
    if (s.show == false) 
    {
      iterator.remove();
      score += 5;
    }
    if (initial)
    {
      iterator.remove();
    }
  }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void CheckScore()
{
  fill(255);
  textSize(25);
  text(score, 7, 123);

  if (score % 150 == 0 && score>0) screenNumber = 9;
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void lighting()
{
  if (hitLight>0 && hitLight<101) 
  {
    hitLight-=10;
    lightOn=true;
  }
  if (hitLight==0) lightOn=false;

  noStroke();
  fill(255, 0, 0, hitLight);
  rect(0, 0, width, height);
  if (lightOn) 
  {
    directionalLight(160, 160, 500, 0, 0, -1);
    ambientLight(0, 0, 255);
  }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void outside()
{
  float x=1, y=0;
  image(Scientist, 425, 10);
  //image(Monster1, x, y, 50, 50);
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void Help()
{
  textSize(12);
  fill(255, 0, 0);
  rect(365, 525, 50, 15);
  rect (475, 525, 50, 15);
  rect (0, 0, 100, 20);
  fill(255);
  text ("Help", 373, 535);
  text ("Pass x", 477, 535);
  text(Pass, 518, 535);
  text("Main Menu", 10, 15);
  
  //pass button
  if (mouseX>=475 && mouseX<=525 && mouseY>=525 && mouseY<=540) cursor(HAND);

  //help button
  if (mouseX>=365 && mouseX<=415 && mouseY>=525 && mouseY<=540)
  {
    cursor(HAND);
    if (mousePressed)
    {
      help = true;
    }
  }
  
  if (help)
  {
    if (keyPressed)
    {
      help = false;
    }
    else 
    {
      if (Level == 1) image (tutorialOne, 0, 0); 
      if (Level == 2) image (tutorialTwo, 0, 0); 
      if (Level == 3) image (tutorialThree, 0, 0); 
      if (Level == 4) image (tutorialFour, 0, 0);
      fill(255);
      rect (0, 570, 180, 80);
    }
  }
  //menu button
  if (mouseX<=100 && mouseY<=20) 
  {
    cursor(HAND);
    if (mousePressed) screenNumber = 1; 
    initial();
  }
  
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void initial()
{
  initial = true;
  lives = 3;
  LoseHealth = 0;
  CookieNumber = 0;
  Pass = 3;
  textEnteredTop ="";
  textEnteredBottom = "";
}

int QuestionNumber=(int) random(1, 11);

public void Question()
{
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  if (Level == 1)
  {
    if (QuestionNumber == 1)
    {
      textSize(30);
      fill(0);
      text (" 9   3", 35, 455);
      text ("14  14", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 2)
    {
      textSize(30);
      fill(0);
      text (" 4   2", 35, 455);
      text ("15  15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 3)
    {
      textSize(30);
      fill(0);
      text ("6    2", 35, 455);
      text ("9    9", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 4)
    {
      textSize(30);
      fill(0);
      text (" 2   1", 35, 455);
      text ("18  18", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }   
    if (QuestionNumber == 5)
    {
      textSize(30);
      fill(0);
      text (" 6   3", 35, 455);
      text ("12  12", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }  
    if (QuestionNumber == 6)
    {
      textSize(30);
      fill(0);
      text (" 8   1", 35, 455);
      text ("10  10", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 7)
    {
      textSize(30);
      fill(0);
      text ("5    2", 35, 455);
      text ("9    9", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 8)
    {
      textSize(30);
      fill(0);
      text ("4    1", 35, 455);
      text ("8    8", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 9)
    {
      textSize(30);
      fill(0);
      text (" 5   3", 35, 455);
      text ("15  15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 10)
    {
      textSize(30);
      fill(0);
      text (" 8   5", 35, 455);
      text ("14  14", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 11)
    {
      textSize(30);
      fill(0);
      text (" 5   3", 35, 455);
      text ("15  15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 12)
    {
      textSize(30);
      fill(0);
      text (" 6   5", 35, 455);
      text ("18  18", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 13)
    {
      textSize(30);
      fill(0);
      text (" 8   2", 35, 455);
      text ("15  15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 14)
    {
      textSize(30);
      fill(0);
      text ("4   1", 35, 455);
      text ("8   8", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("", 65, 475);
    }
    if (QuestionNumber == 15)
    {
      textSize(30);
      fill(0);
      text ("3    1", 35, 455);
      text ("8    8", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 16)
    {
      textSize(30);
      fill(0);
      text (" 4   1", 35, 455);
      text ("14  14", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 17)
    {
      textSize(30);
      fill(0);
      text (" 4   3", 35, 455);
      text ("12  12", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 18)
    {
      textSize(30);
      fill(0);
      text (" 8   3", 35, 455);
      text ("10  10", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 19)
    {
      textSize(30);
      fill(0);
      text (" 9   7", 35, 455);
      text ("12  12", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 20)
    {
      textSize(30);
      fill(0);
      text (" 8   4", 35, 455);
      text ("15  15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  else if (Level == 2)
  {
    if (QuestionNumber == 1)
    {
      textSize(30);
      fill(0);
      text ("4    1", 35, 455);
      text ("9    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 2)
    {
      textSize(30);
      fill(0);
      text (" 7    1", 35, 455);
      text ("14   7", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 3)
    {
      textSize(30);
      fill(0);
      text (" 5    2", 35, 455);
      text ("18   9", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 4)
    {
      textSize(30);
      fill(0);
      text (" 9    4", 35, 455);
      text ("16   8", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 5)
    {
      textSize(30);
      fill(0);
      text (" 8    2", 35, 455);
      text (" 5   15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 6)
    {
      textSize(30);
      fill(0);
      text ("4   9", 35, 455);
      text ("8  24", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 7)
    {
      textSize(30);
      fill(0);
      text ("6   8", 35, 455);
      text ("7  14", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 8)
    {
      textSize(30);
      fill(0);
      text (" 9   9", 35, 455);
      text (" 4  16", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 9)
    {
      textSize(30);
      fill(0);
      text (" 9   1", 35, 455);
      text ("12   3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 10)
    {
      textSize(30);
      fill(0);
      text ("7    1", 35, 455);
      text ("9   27", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("-", 65, 475);
    }
    if (QuestionNumber == 11)
    {
      textSize(30);
      fill(0);
      text (" 5   9", 35, 455);
      text ("12  10", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 12)
    {
      textSize(30);
      fill(0);
      text ("3   1", 35, 455);
      text ("9  12", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 13)
    {
      textSize(30);
      fill(0);
      text (" 7   3", 35, 455);
      text ("10  20", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 14)
    {
      textSize(30);
      fill(0);
      text (" 8   1", 35, 455);
      text ("18   6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 15)
    {
      textSize(30);
      fill(0);
      text (" 2   1", 35, 455);
      text (" 3   6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 16)
    {
      textSize(30);
      fill(0);
      text ("5   2", 35, 455);
      text ("9  18", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 17)
    {
      textSize(30);
      fill(0);
      text (" 5   2", 35, 455);
      text ("24   8", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 18)
    {
      textSize(30);
      fill(0);
      text (" 4   5", 35, 455);
      text ("45  15", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 19)
    {
      textSize(30);
      fill(0);
      text ("1   1", 35, 455);
      text ("9   2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
    if (QuestionNumber == 20)
    {
      textSize(30);
      fill(0);
      text (" 6   5", 35, 455);
      text ("12   6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("+", 65, 475);
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  else if (Level == 3)
  {
    if (QuestionNumber == 1)
    {
      textSize(30);
      fill(0);
      text ("1    5", 35, 455);
      text ("4    7", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 2)
    {
      textSize(30);
      fill(0);
      text ("3    1", 35, 455);
      text ("7    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 3)
    {
      textSize(30);
      fill(0);
      text ("3    3", 35, 455);
      text ("4    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 4)
    {
      textSize(30);
      fill(0);
      text ("1    2", 35, 455);
      text ("7    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 5)
    {
      textSize(30);
      fill(0);
      text ("2    1", 35, 455);
      text ("7    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 6)
    {
      textSize(30);
      fill(0);
      text ("1    1", 35, 455);
      text ("2    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 7)
    {
      textSize(30);
      fill(0);
      text ("1    3", 35, 455);
      text ("2    7", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 8)
    {
      textSize(30);
      fill(0);
      text ("4    2", 35, 455);
      text ("6    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 9)
    {
      textSize(30);
      fill(0);
      text ("3    4", 35, 455);
      text ("4    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }

    if (QuestionNumber == 10)
    {
      textSize(30);
      fill(0);
      text ("3    1", 35, 455);
      text ("6    2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }

    if (QuestionNumber == 11)
    {
      textSize(30);
      fill(0);
      text ("2    1", 35, 455);
      text ("5    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 12)
    {
      textSize(30);
      fill(0);
      text ("3    2", 35, 455);
      text ("5    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 13)
    {
      textSize(30);
      fill(0);
      text ("1    4", 35, 455);
      text ("2    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 14)
    {
      textSize(30);
      fill(0);
      text ("2    4", 35, 455);
      text ("3    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 15)
    {
      textSize(30);
      fill(0);
      text ("3    1", 35, 455);
      text ("5    2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 16)
    {
      textSize(30);
      fill(0);
      text ("1    2", 35, 455);
      text ("3    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 17)
    {
      textSize(30);
      fill(0);
      text ("5    2", 35, 455);
      text ("7    6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 18)
    {
      textSize(30);
      fill(0);
      text ("5    2", 35, 455);
      text ("7    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
    if (QuestionNumber == 19)
    {
      textSize(30);
      fill(0);
      text ("3    1", 35, 455);
      text ("6    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }

    if (QuestionNumber == 20)
    {
      textSize(30);
      fill(0);
      text ("5    1", 35, 455);
      text ("7    2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("x", 65, 475);
    }
  }
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  else if (Level == 4)
  {
    if (QuestionNumber == 1)
    {
      textSize(30);
      fill(0);
      text ("1    1", 35, 455);
      text ("2    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 2)
    {
      textSize(30);
      fill(0);
      text ("1    3", 35, 455);
      text ("3    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 3)
    {
      textSize(30);
      fill(0);
      text ("1    1", 35, 455);
      text ("6    2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 4)
    {
      textSize(30);
      fill(0);
      text ("6    1", 35, 455);
      text ("7    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 5)
    {
      textSize(30);
      fill(0);
      text ("4    1", 35, 455);
      text ("7    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 6)
    {
      textSize(30);
      fill(0);
      text ("5    1", 35, 455);
      text ("7    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 7)
    {
      textSize(30);
      fill(0);
      text ("2    1", 35, 455);
      text ("3    2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 8)
    {
      textSize(30);
      fill(0);
      text ("3    2", 35, 455);
      text ("5    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 9)
    {
      textSize(30);
      fill(0);
      text ("4    1", 35, 455);
      text ("5    2", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 10)
    {
      textSize(30);
      fill(0);
      text ("1    4", 35, 455);
      text ("2    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 11)
    {
      textSize(30);
      fill(0);
      text ("3    4", 35, 455);
      text ("6    7", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 12)
    {
      textSize(30);
      fill(0);
      text ("1    2", 35, 455);
      text ("3    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 13)
    {
      textSize(30);
      fill(0);
      text ("1    3", 35, 455);
      text ("2    4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 14)
    {
      textSize(30);
      fill(0);
      text ("5     1", 35, 455);
      text ("7     4", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 15)
    {
      textSize(30);
      fill(0);
      text ("1    1", 35, 455);
      text ("2    3", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 16)
    {
      textSize(30);
      fill(0);
      text ("2    3", 35, 455);
      text ("5    6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 17)
    {
      textSize(30);
      fill(0);
      text ("1    5", 35, 455);
      text ("3    6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }  
    if (QuestionNumber == 18)
    {
      textSize(30);
      fill(0);
      text ("2    1", 35, 455);
      text ("4    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 19)
    {
      textSize(30);
      fill(0);
      text ("1    3", 35, 455);
      text ("4    6", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
    if (QuestionNumber == 20)
    {
      textSize(30);
      fill(0);
      text ("3    4", 35, 455);
      text ("4    5", 35, 500);
      textSize(50);
      text ("_  _", 35, 465);
      textSize(30);
      text ("\u00f7", 65, 475);
    }
  }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void NewQuestion()
{
  correct = true;
  CookieNumber += 3;
  QuestionNumber = (int) random (1, 11); 
  textEnteredTop ="";
  textEnteredBottom = "";
  numerator = true;
}

boolean loading = true;
boolean tickle1 = false, tickle2 = false, tickle3 = false;
float misplaceX1 = 0, misplaceY1 = 0;
float misplaceX2 = 0, misplaceY2 = 0;
float misplaceY3 = 0;

//////////////////////////////////////////////////////////////////////Logo Screen///////////////////////////////////////////////////////////////////////////////////////////////
public void LogoScreen()
{
  logoAnimation.play();
  //logoAnimation.noLoop();
  image (logoAnimation, 0, 0);
  logoAnimation.pause();

  stroke(255);
  if (loading == true)
  {
    cursor(ARROW);
    textSize(14);
    fill(0);
    textAlign(LEFT);
    text ("LOADING " + PApplet.parseInt((frameCount%401) / 3) + "%", 180, 530);
    rect(175, 538, 204, 24);
    fill(255);
    int fillX = ((frameCount%401) / 3 * 2);
    rect(377, 540, fillX-200, 20);
    if (frameCount%301 == 0)
    {
      loading = false;
    }
  }
  if (loading == false)
  {
    textSize(12);
    fill(0);
    rect(175, 538, 204, 24);
    text ("LOADING 100%", 180, 530);

    textSize(50);
    text ("Click to Continue", 50, 625);
    cursor(HAND);
    if (mousePressed) screenNumber++;
  }
}

//////////////////////////////////////////////////////////////////////Title Screen///////////////////////////////////////////////////////////////////////////////////////////////
public void TitleScreen()
{
  menuAnimation.play();
  image (menuAnimation, 0, 0);
  menuAnimation.pause();

  fill(255);
  textSize(50);
  text ("Play", 225 + misplaceX1, 375+misplaceY1);
  //text ("Instructions", 150+ misplaceX2, 500+misplaceY2);

  if (mouseX>=225 && mouseX<=325 && mouseY>=360 && mouseY<=395 )
  {
    tickle1 = true;
    if (mousePressed) 
    {
      screenNumber = 2;
      tickle1 = false;
    }
  }
  else tickle1 = false;

  if (tickle1)
  {
    cursor(HAND);
    misplaceY1 = misplaceY1 + random(-2, 2);
  }
  else if (!tickle1)
  {
    cursor (ARROW);
    misplaceX1 = misplaceY1 = 0;
  }
}

//////////////////////////////////////////////////////////////////////Character Screen//////////////////////////////////////////////////////////////////////////////////////////
public void CharacterScreen()
{
  background(0xff6A8FD6);
  textSize(40);
  text ("Choose your character", 50, 75);

  image (Female, 75, 100);
  text("Kylie", 110, 350);

  image (Male, 325, 100);
  text("Kaydin", 340, 350);

  image (Duck, 50, 375);
  text ("Sam", 82, 635);

  image (Bear, 215, 375);
  text ("Jam", 260, 635);

  image (Panda, 380, 385);
  text ("Pam", 420, 635);

  if (mouseX>=90 && mouseX<=225 && mouseY>=100 && mouseY<=350)
  {
    cursor(HAND); 
    if (mousePressed)
    {
      gender = 1;
      screenNumber = 3;
    }
  }
  else if (mouseX>=340 && mouseX<=445 && mouseY>=100 && mouseY<=350)
  {
    cursor(HAND); 
    if (mousePressed)
    {
      gender = 2;
      screenNumber = 3;
    }
  }
  else if (mouseX>=65 && mouseX<=180 && mouseY>=400 && mouseY<=635)
  {
    cursor(HAND);
    if (mousePressed)
    {
      gender = 3;
      screenNumber = 3;
    }
  }
  else if (mouseX>=225 && mouseX<=345 && mouseY>=395 && mouseY<=635)
  {
    cursor(HAND);
    if (mousePressed)
    {
      gender = 4;
      screenNumber = 3;
    }
  }
  else if (mouseX>=390 && mouseX<=520 && mouseY>=395 && mouseY<=635)
  {
    cursor(HAND);
    if (mousePressed)
    {
      gender = 5;
      screenNumber = 3;
    }
  }
  else cursor(ARROW);
}

//////////////////////////////////////////////////////////////////////Instrucion Screen/////////////////////////////////////////////////////////////////////////////
public void InstructionsScreen()
{
  image(InstructionBackground, 0, 0);
  fill(0);
  textSize(20);
  text("Press any letter to continue.", 150, 170);
  if (keyPressed == true) screenNumber = 4;

  textSize(50);
  text("\u2190", 10, 35);
  if (mouseX <= 55 && mouseY <= 30)
  {
    cursor (HAND); 
    if (mousePressed) screenNumber = 2;
  }
  else cursor (ARROW);
}

//////////////////////////////////////////////////////////////////////Level Screen////////////////////////////////////////////////////////////////////////////////////////////////
public void LevelScreen()
{
  background(LevelBackground);
  if (mouseX>0 && mouseX<=320 && mouseY>75 && mouseY <= 230)
  {
    cursor(HAND);
    if (mousePressed)
    {
      Level = 1;
      initial();
      screenNumber = 8;
    }
  }
  else if (mouseX>165 && mouseX<=width && mouseY>240 && mouseY<=375 )
  {
    cursor(HAND);
    if (mousePressed)
    {
      Level = 2;
      initial();
      screenNumber = 8;
    }
  }
  else if (mouseX>0 && mouseX<=392 && mouseY>380 && mouseY<=540 )
  {
    cursor(HAND);
    if (mousePressed)
    {
      Level = 3;
      initial();
      screenNumber = 8;
    }
  }
  else if (mouseX>170 && mouseX<=width && mouseY>540 && mouseY<=height )
  {
    cursor(HAND);
    if (mousePressed)
    {
      Level = 4;
      initial();
      screenNumber = 8;
    }
  }
  else cursor(ARROW);
}
//////////////////////////////////////////////////////////////////////Tutorial Screen/////////////////////////////////////////////////////////////////////////////////////////////
public void TutorialScreen()
{
  boolean back=false;
  if (Level == 1)
  {
    tutorialOne.play();
    image (tutorialOne, 0, 0);
    fill(255);
    textSize(25);
    text ("Easy", 195, 45);
    initial();
    if (keyPressed == true) 
    {
      initial = true;
      screenNumber = 5;
    }
  }
  if (Level == 2)
  {
    tutorialTwo.play();
    image (tutorialTwo, 0, 0);
    fill(255);
    textSize(25);
    text ("Intermediate", 195, 45);
    initial();
    if (keyPressed == true) 
    {
      initial = true;
      screenNumber = 5;
    }
  }
  if (Level == 3)
  {
    tutorialThree.play();
    image (tutorialThree, 0, 0);
    fill(255);
    textSize(25);
    text ("Advance", 195, 45);
    initial();
    if (keyPressed == true) 
    {
      initial = true; 
      screenNumber = 5;
    }
  }
  if (Level == 4)
  {
    tutorialFour.play();
    image (tutorialFour, 0, 0);
    fill(255);
    textSize(25);
    text ("Extreme", 195, 45);
    initial();
    if (keyPressed == true) 
    {
      initial = true; 
      screenNumber = 5;
    }
  } 

  if (mouseX <= 180 && mouseY >= 540) 
  {
    cursor (HAND);
    if (mousePressed)screenNumber = 4;
  }
  else cursor(ARROW);
}

//////////////////////////////////////////////////////////////////////Game Over Screen//////////////////////////////////////////////////////////////////////////////////////////
public void GameOverScreen()
{
  background(GameOverBackgound); 
  if (gender == 1) image(Female, 325, 150);
  else if (gender == 2) image(Male, 325, 150);
  else if (gender == 3) image (Duck, 325, 150);
  else if (gender == 4) image (Bear, 325, 150);
  else if (gender == 5) image (Panda, 325, 150);

  fill(0);
  textSize (50);
  text ("Highest", 15, 275);
  text ("  Score:", 15, 325);
  text (score, 230, 325);

  text("Main Menu", 10+misplaceX1, 515+misplaceY1);
  text("Credits", 50+misplaceX2, 600+misplaceY2);

  if (mouseX>=15 && mouseX<=275 && mouseY>=475 && mouseY<=515 )
  {
    tickle1 = true;
    if (mousePressed) 
    {
      initial();
      score = 0;
      screenNumber = 1;
      tickle1 = false;
    }
  }
  else tickle1 = false;
  if (mouseX>=50 && mouseX<=215 && mouseY>=560 && mouseY<=600)
  {
    tickle2 = true;
    if (mousePressed) 
    {
      screenNumber = 7;
      tickle2 = false;
    }
  }
  else tickle2 = false;
  if (tickle1)
  {
    cursor(HAND);
    misplaceY1 = misplaceY1 + random(-2, 2);
  }
  else if (!tickle1)
  {
    cursor (ARROW);
    misplaceX1 = misplaceY1 = 0;
  }
  if (tickle2)
  {
    cursor(HAND);
    misplaceY2 = misplaceY2 + random(-2, 2);
  }
  else if (!tickle2)
  {
    cursor (ARROW);
    misplaceX2 = misplaceY2 = 0;
  }
}
//////////////////////////////////////////////////////////////////////Credit Screen//////////////////////////////////////////////////////////////////////////////////////////////
public void CreditScreen()
{
  image(CreditBackground, 0, 0);
  //text("Main Menu", 10+misplaceX1, 515+misplaceY1);
  if (mouseX>=47 && mouseX<=520 && mouseY>=108 && mouseY<=470 )
  {
    cursor(HAND);
    if (mousePressed) 
    {
      initial();
      score = 0;
      screenNumber = 1;
      tickle1 = false;
    }
  }
  else cursor (ARROW);
}
//////////////////////////////////////////////////////////////////////Winner Screen////////////////////////////////////////////////////////////////////////////////////////////////
public void WinnerScreen()
{
  image (WinnerBackground, 0, 0); 
  if (gender == 1) image(Female, 325, 150);
  else if (gender == 2) image(Male, 325, 150);
  else if (gender == 3) image (Duck, 325, 150);
  else if (gender == 4) image (Bear, 325, 150);
  else if (gender == 5) image (Panda, 325, 150);

  fill(0);
  textSize (50);
  text ("Highest", 15, 275);
  text ("  Score:", 15, 325);
  text (score, 230, 325);


  text("Main Menu", 10+misplaceX1, 515+misplaceY1);
  text("Credits", 50+misplaceX2, 600+misplaceY2);


  if (Level < 4) 
  {
    text("Next Level", 10, 430+misplaceY3);
    if (mouseX>=15 && mouseX<=265 && mouseY>=392 && mouseY<=430)
    {
      tickle3 = true;
      if (mousePressed)
      {
        initial();
        if (Level == 1)
        {
          Level = 2;
          screenNumber = 8;
          score += 5;
        }
        else if (Level == 2)
        {
          Level = 3;
          screenNumber = 8; 
          score += 5;
        }
        else if (Level == 3)
        {
          Level = 4;
          screenNumber = 8; 
          score += 5;
        }
      }
    }
    else tickle3 = false;
  }
  else if (Level == 4) 
  {
    textSize(15);
    text ("Good Job, you have passed", 10, 365);
    text ("all of the levels!", 10, 430);
  }
  if (mouseX>=15 && mouseX<=275 && mouseY>=475 && mouseY<=515 )
  {
    tickle1 = true;
    if (mousePressed) 
    {
      initial();
      score = 0;
      screenNumber = 1;
      tickle1 = false;
    }
  }
  else tickle1 = false;
  if (mouseX>=50 && mouseX<=215 && mouseY>=560 && mouseY<=600)
  {
    tickle2 = true;
    if (mousePressed) 
    {
      screenNumber = 7;
      tickle2 = false;
    }
  }
  else tickle2 = false;
  if (tickle1)
  {
    cursor(HAND);
    misplaceY1 = misplaceY1 + random(-2, 2);
  }
  else if (!tickle1)
  {
    cursor (ARROW);
    misplaceX1 = misplaceY1 = 0;
  }
  if (tickle2)
  {
    cursor(HAND);
    misplaceY2 = misplaceY2 + random(-2, 2);
  }
  else if (!tickle2)
  {
    cursor (ARROW);
    misplaceX2 = misplaceY2 = 0;
  }
  if (tickle3)
  {
    cursor(HAND);
    textSize (15);
    text ("Bonus", 285, 400);
    text ("5 points", 285, 420);
    misplaceY3 = misplaceY3 + random(-2, 2);
  }
  else if (!tickle3)
  {
    cursor (ARROW);
    misplaceY3 = 0;
  }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "Cookie_Attack_May_9" });
  }
}
