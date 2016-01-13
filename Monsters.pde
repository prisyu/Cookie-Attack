class Monsters
{
  float x, y;
  float x0 = random(135, 450);
  float y0 = random (100, 300);

  float speed = 0.5;
  boolean goIn = false;
  boolean show;

  int number = MonsterNumber;

  Monsters(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  void show()
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
  void move() 
  {
    if (!goIn)
    {
      if (x>120) x-= speed+0.5;
      if (x<275 && x >200) call = true;
      else if (x<=120) goIn = true;
    }
    if (goIn)
    {
      if (y >= y0) 
      {
        y += speed/4;
        if (x <= x0) x += speed+0.5;
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

