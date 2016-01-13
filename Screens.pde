boolean loading = true;
boolean tickle1 = false, tickle2 = false, tickle3 = false;
float misplaceX1 = 0, misplaceY1 = 0;
float misplaceX2 = 0, misplaceY2 = 0;
float misplaceY3 = 0;

//////////////////////////////////////////////////////////////////////Logo Screen///////////////////////////////////////////////////////////////////////////////////////////////
void LogoScreen()
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
    text ("LOADING " + int((frameCount%401) / 3) + "%", 180, 530);
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
void TitleScreen()
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
void CharacterScreen()
{
  background(#6A8FD6);
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
void InstructionsScreen()
{
  image(InstructionBackground, 0, 0);
  fill(0);
  textSize(20);
  text("Press any letter to continue.", 150, 170);
  if (keyPressed == true) screenNumber = 4;

  textSize(50);
  text("←", 10, 35);
  if (mouseX <= 55 && mouseY <= 30)
  {
    cursor (HAND); 
    if (mousePressed) screenNumber = 2;
  }
  else cursor (ARROW);
}

//////////////////////////////////////////////////////////////////////Level Screen////////////////////////////////////////////////////////////////////////////////////////////////
void LevelScreen()
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
void TutorialScreen()
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
void GameOverScreen()
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
void CreditScreen()
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
void WinnerScreen()
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

