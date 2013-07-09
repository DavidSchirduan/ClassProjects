#---------
# Licensing Information: Please do not distribute or publish solutions to this
# project. You are free to use and extend these projects for educational
# purposes. The Pacman AI projects were developed at UC Berkeley, primarily by
# John DeNero (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# For more info, see http://inst.eecs.berkeley.edu/~cs188/sp09/pacman.html

"""
In search.py, you will implement generic search algorithms which are called
by Pacman agents (in searchAgents.py).
"""
    
import util
import time
from collections import deque

class SearchProblem:
    """
    This class outlines the structure of a search problem, but doesn't implement
    any of the methods (in object-oriented terminology: an abstract class).

    You do not need to change anything in this class, ever.
    """

    def getStartState(self):
        """
        Returns the start state for the search problem
        """
        util.raiseNotDefined()

    def isGoalState(self, state):
        """
          state: Search state

        Returns True if and only if the state is a valid goal state
        """
        util.raiseNotDefined()

    def getSuccessors(self, state):
        """
          state: Search state

        For a given state, this should return a list of triples,
        (successor, action, stepCost), where 'successor' is a
        successor to the current state, 'action' is the action
        required to get there, and 'stepCost' is the incremental
        cost of expanding to that successor
        """
        util.raiseNotDefined()

    def getCostOfActions(self, actions):
        """
         actions: A list of actions to take

        This method returns the total cost of a particular sequence of actions.  The sequence must
        be composed of legal moves
        """
        util.raiseNotDefined()


def tinyMazeSearch(problem):
    """
    Returns a sequence of moves that solves tinyMaze.  For any other
    maze, the sequence of moves will be incorrect, so only use this for tinyMaze
    """
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    return  [s,s,w,s,w,w,s,w]

def depthFirstSearch(problem):
    """
    Search the deepest nodes in the search tree first

    Your search algorithm needs to return a list of actions that reaches
    the goal.  Make sure to implement a graph search algorithm

    To get started, you might want to try some of these simple commands to
    understand the search problem that is being passed in:

    print "Start:", problem.getStartState()
    print "Is the start a goal?", problem.isGoalState(problem.getStartState())
    print "Start's successors:", problem.getSuccessors(problem.getStartState())
    """
    #Code written by David Schirduan, 1/24/13 as of last update
    #make pacman take as long as possible to find the goal, otherwise known as DFS 
    #util.raiseNotDefined()
    
    state = problem.getStartState()
    
    #start to iterate through the successors
    global directions
    directions = []
    explored = []
    #print "Explored :", explored
    correctPath = []
    header = "derp"
    #util.pause()#so that I can see what is happening

    def iter(explored, correct, current, direc):
        explored.append(current) #add to the explored list
       # debugging code and such
       # print "Current: ", current
       # print "Explored: ",explored
       # print "successors: ", problem.getSuccessors(current)
       # print "correct: ", correct, "\n"
        correct.append(direc)
        for i in problem.getSuccessors(current):
            if problem.isGoalState(i[0]):
                correct.append(i[1])
        #        print "FINAL correct: ", correct
                directions.append(correct)
            elif i[0] not in explored:
         #       print "correct being passed: ", correct, "\n"
                iter(explored, correct[:], i[0], i[1])        
    
    iter(explored, correctPath[:], state, header)
    directions[0].remove(header)
    #print directions[0]
    return directions[0]

def breadthFirstSearch(problem):
    """
    Search the shallowest nodes in the search tree first.
    """
    "*** YOUR CODE HERE ***"
    #Code written by David Schirduan, 1/24/13 as of last update
    #make pacman take as long as possible to find the goal, otherwise known as Bread First Search 
    # currently finds the goal, but can't return the correct path 
    state = problem.getStartState()
    
    #start to iterate through the successors
    explored = []
    frontier = util.Queue()
    temppath = []

    #need to make a list of lists
    def bread(start):
        directions = []
        goalFound = False
        frontier.push((start, temppath))
        #explored.append(start)
        while frontier and not goalFound: #while correctPath is not empty and goal not found
            current = frontier.pop()
            explored.append(current[0])
            #print "Explored: ",explored
            #print "temppath: ", current[1]
            #util.pause()#so that I can see what is happenin
            if problem.isGoalState(current[0]):
                print "Found it!"
                goalFound = True
                return current[1]
            #directions.append(x)
            for i in problem.getSuccessors(current[0]):
                #print "x1: ",current[1]
                #print "i = ", i, "\n"
                if i[0] not in explored:
                    current[1].append(i[1])
                    frontier.push((i[0], current[1][:]))

    print bread(state)

    #util.pause()#so that I can see what is happenin
    util.raiseNotDefined()

"""
pass in the cost of the successors, added to the previous cost
each time, for each successor, push the cost, the state, and the temp path
"""

def uniformCostSearch(problem):
    "Search the node of least total cost first. "
    "*** YOUR CODE HERE ***"
    state = problem.getStartState()
    
    #start to iterate through the successors
    explored = []
    frontier = util.PriorityQueue()
    temppath = []

    #need to make a list of lists
    def uniform(start):
        directions = []
        goalFound = False
        frontier.push((start, temppath), 0)
        #explored.append(start)
        while frontier and not goalFound: #while correctPath is not empty and goal not found
            piece = frontier.pop()
            current = piece[0]
            cost = piece[1]
            explored.append(current[0])
            print "Explored: ",explored
            print "current: ",current
            print "cost: ",cost
#            print "x1: ",x[1]
            #util.pause()#so that I can see what is happenin
            #directions.append(x)
            if problem.isGoalState(current[0]):
                print "Found it!"
                goalFound = True
                return current[1]
            for i in problem.getSuccessors(current[0]):
                if i[0] not in explored:
                    current[1].append(i[1])
                    cost = cost + i[2] #increment the total cost
                    frontier.push((i[0], current[1][:]), cost[:])

    print uniform(state)

    util.raiseNotDefined()

def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

"""
still a pqueue, but add manhattan distance in addition to the nezt path cost.
need to subtract the previous distance.
"""

def aStarSearch(problem, heuristic=nullHeuristic):
    "Search the node that has the lowest combined cost and heuristic first."
    "*** YOUR CODE HERE ***"
    
    #need to use manhattan distance to calculate h
    #g can be calculated with the priority Q
    state = problem.getStartState()
    
    #start to iterate through the successors
    explored = []
    frontier = util.PriorityQueue()
    temppath = []

    #need to make a list of lists
    def star(start):
        directions = []
        goalFound = False
        frontier.push((start, temppath), 0)
        #explored.append(start)
        while frontier and not goalFound: #while correctPath is not empty and goal not found
            current = frontier.pop()
            explored.append(current[0])
            print "Explored: ",explored
#            print "x1: ",x[1]
            #util.pause()#so that I can see what is happenin
            #directions.append(x)
            if problem.isGoalState(current[0]):
                print "Found it!"
                goalFound = True
                return current[1]
            for i in problem.getSuccessors(current[0]):
                print "x1: ",current[1]
                print "i = ", i, "\n"
                if i[0] not in explored:
                    current[1].append(i[0])
                    frontier.push((i[0], current[1][:]), i[2])

    print star(state)


    util.raiseNotDefined()


# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
