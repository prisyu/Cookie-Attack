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
void PlayScreen()
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
void mouse()
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
void mousePressed()
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
void CheckHealth()
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
void CheckLife()
{
  for (int i=0; i < lives; i=i+1)image (Heart, 475+i*25, 100);
  if (lives <= 0) screenNumber = 6;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void CheckCookie()
{
  image (Cookie4, 375, 413, 20, 20);
  textSize(20);
  fill(255);
  text("x", 405, 428);
  text(CookieNumber, 425, 430);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void CheckMonster()
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
void CheckScore()
{
  fill(255);
  textSize(25);
  text(score, 7, 123);

  if (score % 150 == 0 && score>0) screenNumber = 9;
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void lighting()
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
void outside()
{
  float x=1, y=0;
  image(Scientist, 425, 10);
  //image(Monster1, x, y, 50, 50);
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void Help()
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
void initial()
{
  initial = true;
  lives = 3;
  LoseHealth = 0;
  CookieNumber = 0;
  Pass = 3;
  textEnteredTop ="";
  textEnteredBottom = "";
}

