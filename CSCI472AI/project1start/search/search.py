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

    #need to make a list of lists
    def bread(start):
        directions = []
        goalFound = False
        frontier.push(start)
        #explored.append(start)
        while frontier and not goalFound: #while correctPath is not empty and goal not found
            x = frontier.pop()
            explored.append(x)
            print "Explored: ",explored
            print "directions: ",directions
            util.pause()#so that I can see what is happenin
            #directions.append(x)
            if problem.isGoalState(x):
                print "Found it!"
                goalFound = True
                return frontier
            for i in problem.getSuccessors(x):
                print "i = ", i, "\n"
                if i[0] not in explored:
                    frontier.push(i[0])

    bread(state)

    #util.pause()#so that I can see what is happenin
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
