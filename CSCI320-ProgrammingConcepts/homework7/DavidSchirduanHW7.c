/*David Schirduan Homework 7 11-2-11*/
# include <stdio.h>
# include <stdlib.h>
# include <string.h>


struct flight_info
{
	int flightNumber;
	char origAirport[3];
	char destAirport[3];
	char departureTime[4];
} ;

struct linked_list /* a node in the list*/
{
	struct flight_info *flight;
	struct linked_list *next;
} ;


/*create a head node first*/
struct linked_list *headNum = NULL;

/*create a head node first*/
struct linked_list *headTime = NULL;

int main() {

/* creates multiple flight_info structs*/
struct flight_info * new_ptr1 = (struct flight_info *)malloc(sizeof(struct
flight_info)); /*creates space on the heap for a single struct*/
new_ptr1->flightNumber = 125;
(void)strcpy((* new_ptr1).origAirport, "CHS"); /* copy a string */
(void)strcpy (new_ptr1->destAirport, "CLT");
(void)strcpy (new_ptr1-> departureTime, "1000");

struct flight_info * new_ptr2 = (struct flight_info *)malloc(sizeof(struct
flight_info)); /*creates space on the heap for a single struct*/
new_ptr2->flightNumber = 135;
(void)strcpy((* new_ptr2).origAirport, "ATL"); /* copy a string */
(void)strcpy (new_ptr2->destAirport, "CHI");
(void)strcpy (new_ptr2-> departureTime, "2345");

struct flight_info * new_ptr3 = (struct flight_info *)malloc(sizeof(struct
flight_info)); /*creates space on the heap for a single struct*/
new_ptr3->flightNumber = 270;
(void)strcpy((* new_ptr3).origAirport, "UKA"); /* copy a string */
(void)strcpy (new_ptr3->destAirport, "CPP");
(void)strcpy (new_ptr3-> departureTime, "0800");

struct flight_info * new_ptr4 = (struct flight_info *)malloc(sizeof(struct
flight_info)); /*creates space on the heap for a single struct*/
new_ptr4->flightNumber = 40;
(void)strcpy((* new_ptr4).origAirport, "WWF"); /* copy a string */
(void)strcpy (new_ptr4->destAirport, "MLA");
(void)strcpy (new_ptr4-> departureTime, "1700");

struct flight_info * new_ptr5 = (struct flight_info *)malloc(sizeof(struct
flight_info)); /*creates space on the heap for a single struct*/
new_ptr5->flightNumber = 25;
(void)strcpy((* new_ptr5).origAirport, "TNT"); /* copy a string */
(void)strcpy (new_ptr5->destAirport, "MSN");
(void)strcpy (new_ptr5-> departureTime, "0015");


insert_flightNum(new_ptr1, headNum);
insert_flightNum(new_ptr2, headNum);
insert_flightNum(new_ptr3, headNum);
insert_flightNum(new_ptr4, headNum);
insert_flightNum(new_ptr5, headNum);

insert_flightTime(new_ptr1, headTime);
insert_flightTime(new_ptr2, headTime);
insert_flightTime(new_ptr3, headTime);
insert_flightTime(new_ptr4, headTime);
insert_flightTime(new_ptr5, headTime);

/*prints out all of the nodes*/
struct linked_list *printCurrentNum = headNum;
while (printCurrentNum != NULL)
{
printf("Flight Number = %d\n", printCurrentNum->flight->flightNumber);
printf("\tFlight Origin = %s\n", printCurrentNum->flight->origAirport);
printf("\tFlight Destination = %s\n", printCurrentNum->flight->destAirport);
printf("\tFlight Departure Time = %s\n\n", printCurrentNum->flight->departureTime);

printCurrentNum = printCurrentNum->next;
}

/*prints out all of the nodes*/
struct linked_list *printCurrentTime = headTime;
while (printCurrentTime != NULL)
{
printf("Flight Number = %d\n", printCurrentNum->flight->flightNumber);
printf("\tFlight Origin = %s\n", printCurrentNum->flight->origAirport);
printf("\tFlight Destination = %s\n", printCurrentNum->flight->destAirport);
printf("\tFlight Departure Time = %s\n\n", printCurrentNum->flight->departureTime);printCurrentTime = printCurrentTime->next;
}
return 1;
}

void insert_flightNum(struct flight_info *newFlight, struct linked_list *head)
{
struct linked_list *current = head; /*going to track along the linked list*/
struct linked_list *trailer = head; /*going to follow along the current*/
struct linked_list *newNode;/*create new node*/
newNode = malloc(sizeof(struct linked_list));/*create space for new node*/
newNode->flight = newFlight;/*newNode data contains pointers to newflight*/

/*if list is empty, point to newNode*/
if (head == NULL)
{
head->next = newNode;
}

else{
while (current != null)
	{
	/*code to insert if greater than last node*/
		if (newnode->flight->flightnumber > current->flight->flightnumber)
		{
			trailer = current; /*keeps the trailer one behind*/
		}

		if (newnode->flight->flightnumber < current->flight->flightnumber) 
		{/*inserts in the correct place*/
		trailer->next = newnode;
		newnode->next = current;
		current = null;/*kills the loop*/
		}
		
	current = current->next;	
	}
}
}

void insert_flightTime(struct flight_info *newFlight, struct linked_list *head)
{
struct linked_list *current = head; /*going to track along the linked list*/
struct linked_list *trailer = head; /*going to follow along the current*/
struct linked_list *newNode;/*create new node*/
newNode = malloc(sizeof(struct linked_list));/*create space for new node*/
newNode->flight = newFlight;/*newNode data contains pointers to newflight*/

/*if list is empty, point to newNode*/
if (head == NULL)
{
head->next = newNode;
}

else{
while (current != NULL)
	{
	/*code to insert if greater than last node*/
		if (strcmp(newNode->flight->departureTime, current->flight->departureTime) < 0)
		{
			trailer = current; /*keeps the trailer one behind*/
		}

		if (strcmp(newNode->flight->departureTime, current->flight->departureTime) == 0) /*inserts in the correct place*/
		{
		trailer->next = newNode;
		newNode->next = current;
		current = NULL;
		}
		
	current = current->next;	
	}
}
}
