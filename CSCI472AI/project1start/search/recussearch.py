# search.py
# ---------
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
    "*** YOUR CODE HERE ***"
    
    state = problem.getStartState()
    
    #start to iterate through the successors
    directions = []       
    explored = []
    #print "Explored :", explored
    util.pause()#so that I can see what is happening

def iter(explored, correct, current):
        explored.append(current) #add to the explored list
        print "Current: ", current
        print "correct: ", correct
        print "Explored: ",explored
        print "successor s\n", problem.getSuccessors(current)
        
        for i in problem.getSuccessors(current):
            if i in explored:
                print "already been here: ", i, "\n"
            elif (problem.isGoalState(i[0])):
                print "Found the end!\n"
                correct.append(i[0])
            else:
                print "to the next node! ", i, "\n"
                iter(explored, correct, i[0]

#not working because of universal variables, need to be self-contained 
   # x = 0
##    def recurs(current, explored, tempPath, x):
#        explored.append(current) #add to the explored list
 #       print "Current: ", current
  #      print "correct: ", tempPath
   #     print "Explored: ",explored
    #    print "successor s\n", problem.getSuccessors(current)
     #   util.pause()#so that I can see what is happening
      #  if problem.isGoalState(current):
#            print "FOUND!"
 #           tempPath.append(current)
  #          return tempPath
   #     for i in problem.getSuccessors(current):
    #        x = x + 1
     #       print "Loop number: ", x
      #      print "the next i is: \n",i
       #     nextstate = i[0]
        #    nextdirection = i[1]
         #   if nextstate not in explored:
          #      print "new direction available!"
           #     tempPath.append(current)            
            #    tempThing = recurs(nextstate, explored, tempPath, x)
             #   if tempThing:
              #      return tempThing
    #        else:
     #           print "already been here:"
      #  return      

    correctPath = []
   # print "recurs: ",recurs(state, explored, correctPath, x)
    iter(explored, correctPath, state)
    print "final Path: ",correctPath
    util.pause()#so that I can see what is happening
    return directions

def breadthFirstSearch(problem):
    """
    Search the shallowest nodes in the search tree first.
    """
    "*** YOUR CODE HERE ***"
    util.raiseNotDefined()

def uniformCostSearch(problem):
    "Search the node of least total cost first. "
    "*** YOUR CODE HERE ***"
    util.raiseNotDefined()

def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

def aStarSearch(problem, heuristic=nullHeuristic):
    "Search the node that has the lowest combined cost and heuristic first."
    "*** YOUR CODE HERE ***"
    util.raiseNotDefined()


# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
