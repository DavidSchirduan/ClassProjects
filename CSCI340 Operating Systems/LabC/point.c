#include <assert.h>
#include <stdio.h>
#include <math.h>
#include "point.h"

double xdiff;
double ydiff;
double distance;
/*Also had to add -lm to the makefile
 * Update *p by increasing p->x by x and 
 * p->y by y
 * p->x += x;
 * p->y += y;
 */

void point_translate(Point *p, double x, double y)//pass in a pointer to object Point refer {(*p).x = 20;} or {p->x = 20}
{
  p->x += x;
  p->y += y;
}

/*
 * Return the distance from p1 to p2
 * find the distance between the two using the distance formula
 */

double point_distance(const Point *p1, const Point *p2)
{
  xdiff = point_getX(p1) - point_getX(p2);
  ydiff = point_getY(p1) - point_getY(p2);

  distance = sqrt((xdiff*xdiff) + (ydiff*ydiff));
  return distance;
}
