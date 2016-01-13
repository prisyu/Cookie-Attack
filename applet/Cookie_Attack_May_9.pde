 /* Cookie Attack
 * Cookie Dough Productions
 * Game Programmer - Priscilla Yu
 * Production Manager - Angel Lei
 * Graphic Designer - Miranda Kuang
 *  
 * February 13, 2012
 */

import gifAnimation.*;
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

void setup()
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

void draw()
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



