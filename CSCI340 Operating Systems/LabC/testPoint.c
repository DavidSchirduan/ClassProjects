#include <assert.h>
#include <stdlib.h>
#include <stdio.h>

#include "point.h"
//Also had to add -lm to the makefile
int main(int argc, char **argv)
{
  Point p1;
  point_set(&p1, 1.0, 1.0);

  Point *p2 = malloc(sizeof(Point));
  assert(p2);
  point_set(p2, 1.0, 1.0);

  assert(point_distance(&p1, p2) == 0.0);

  point_translate(&p1, 1.0, 0.0);
  assert(point_distance(&p1, p2) == 1.0);

  point_set(&p1, 0.0, 0.0);
  point_set(p2, 3.0, 4.0);
  assert(point_distance(&p1, p2) == 5.0);

  free(p2);
  p2 = NULL;

  printf("OK\n");
  return 0;
 }

