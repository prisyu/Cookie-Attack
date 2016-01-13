class Cookies
{
  int x, y;
  int number = CookieSelect;
  
  Cookies(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  void show()
  {
    y -= 3;
    if (number == 1) image (Cookie1, x-25, y);
    if (number == 2) image (Cookie2, x-25, y);
    if (number == 3) image (Cookie3, x-25, y);
    if (number == 4) image (Cookie4, x-25, y);
  }
}

