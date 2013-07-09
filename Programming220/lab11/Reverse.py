#This program reverses the order of a list

def main():
    nums = [1,2,3,4,5,6,7,8,9]
    nums.reverse()
    print nums

    nums = ["lions", "tigers", "bears", "On my!"]
    nums.reverse()
    print nums

    nums = [1, 2, "Buckle", "shoe", 3, 4, "End"]
    nums.reverse()
    print nums

main()

def reverse(self, list1):
    moveposition = (len(list1)) - 1

    for i in range(len(list1)):
        tempnum = list1.pop(moveposition)

        list1.append(tempnum)

        moveposition = moveposition - 1
    
