#include <assert.h>
#include <stdlib.h>
#include "point.h"
#include "sortedPoints.h"


/*
 * Initialize data structures, returning pointer
 * to the object.
 */
SortedPoints *sp_init(SortedPoints *sp){
  return sp;
}

/*
 * Allocate a new point and initialize it to x,y. Then
 * add that point to the SortedPointss list. Return
 * 1 on success and 0 on error (e.g., out of memory).
 */
int sp_addNewPoint(SortedPoints *sp, double x, double y)
{
  return 0;
}

/*
  * Remove the first point from the sorted list,
  * storing its value in *ret. Returns 1 on success
  * and 0 on failure (empty list).
  */
int sp_removeFirst(SortedPoints *sp, Point *ret)
{
  assert(0); // TBD
  return 0;
}

/*
  * Remove the last point from the sorted list,
  * storing its value in *ret. Returns 1 on success
  * and 0 on failure (empty list).
  */
int sp_removeLast(SortedPoints *sp, Point *ret)
{
  assert(0); // TBD
  return 0;
}



/*
  * Remove the point that appears in position
  * <index> on the sorted list, storing its 
  * value in *ret. Returns 1 on success
  * and 0 on failure (too short list).
  *
  * The first item on the list is at index 0.
  */
int sp_removeIndex(SortedPoints *sp, int index, Point *ret)
{
  assert(0); // TBD
  return 0;
}


/*
  * Delete any duplicate records. E.g., if
  * two points on the list have *identical*
  * x and y values, then delete one of them.
  * Return the number of records deleted.
  */
int sp_deleteDuplicates(SortedPoints *sp)
{
  assert(0); // TBD
  return -1;
}


