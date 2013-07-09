def main():
    startyear = input("What year did you start teaching? ")
    currentyear = input("Up to what year would you like to calulate your salary? ")
    salary = input("What was your starting salary? ")
    percent = input("What is the percent increase of your annual salary? ")
    years = currentyear - startyear

    for i in range (years):
        startyear = startyear + 1
        salary = (percent / 100.0) * salary + salary
        print "$%.02f" %salary, "is your salary by the year", startyear

main()
