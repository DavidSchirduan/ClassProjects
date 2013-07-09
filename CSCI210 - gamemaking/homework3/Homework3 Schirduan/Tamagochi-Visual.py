#
# Author: David Schirduan
# Class: CSCI 210 - 02
# Assignment: Homework 3 - Visual Tamagochi
# Due Date: 4/2/12
#
# Certification of Authenticity <remove one of the following>:
#   I certify that this assignment is my own work, but I received
#   some assistance from: The internet:
#       http://cs.simpson.edu/?q=pygame_base_template.py
#       http://www.devshed.com/c/a/Python/PyGame-for-Game-Development-Font-and-Sprites/2/    
#       And some help from your previous Tamagochi examples
#
# TASK: We must program a basic Tamagochi-like state machine. It loosely follows Maslow's
# Heirarchy, and is accompanied by animations to show the state of the Tamagotchi.
#

import pygame                      
from pygame.locals import *
import sys


screen = pygame.display.set_mode( (600,400), DOUBLEBUF )

Playing = True

clock=pygame.time.Clock()

pygame.display.set_caption("Tamagochi")

State = "Bored" #default states
Food = 0
Nutrition = 100
Toy = False


i = 0 #reset this when a different key is pressed

#Controls Message
pygame.init()
font = pygame.font.Font(None, 30)
text = font.render('[F]ood / [T]oy / [N]othing / [Q]uit', True, (0,0,0), (255, 255, 255))

# Create a text box
textRect = text.get_rect()

# Center the rectangle
textRect.centerx = 175
textRect.centery = 50


##########setup animation loops##########
BoredImages = ["BORED1.png", "BORED2.png", "BORED1.png", "BORED2.png", "BORED1.png", "BORED2.png", "BORED3.png", "BORED4.png", "BORED1.png", "BORED2.png", "BORED3.png", "BORED4.png", "BORED5.png"]
HungryImages = ["HUNGRY1.png","HUNGRY2.png","HUNGRY3.png","HUNGRY4.png","HUNGRY1.png","HUNGRY2.png","HUNGRY3.png","HUNGRY4.png","HUNGRY5.png","HUNGRY6.png","HUNGRY6.png"]
PlayingImages = ["PLAYING1.png","PLAYING2.png","PLAYING1.png","PLAYING2.png","PLAYING3.png","PLAYING4.png","PLAYING3.png","PLAYING4.png","PLAYING5.png","PLAYING5.png"]
EatingImages = ["EATING1.png","EATING2.png","EATING3.png","EATING4.png","EATING2.png","EATING3.png","EATING4.png","EATING2.png","EATING3.png","EATING4.png","EATING5.png"]
Tamagochi = pygame.image.load(BoredImages[i])
Tamagochipos_x = 220
Tamagochipos_y = 150

FoodImage = pygame.image.load("FOOD.png")
ToyImage = pygame.image.load("TOY.png")


while Playing:     #game loop
    
    oldState = State #see what the status was last loop
####################read key presses#################

    events = pygame.event.get()
    for event in events:           

        if event.type == KEYDOWN:   #if Q then quit
            if event.key == K_q:
                Playing = False
                
            elif event.key == K_f:  #add food to the cage
                Food = 100

            elif event.key == K_t:
                Toy = not Toy

            else:
                pass
                ##do nothing##
                

##################apply actions and update states##########

    if Food > 0 and Nutrition < 100:    #eat above all else
        State = "Eating"
        Food = Food - 5
        if Food < 0:
            Food = 0
        Nutrition = Nutrition + 5
        if Nutrition > 100:
            Nutrition = 100
        
    elif Nutrition <= 25:
        State = "Hungry"
    else:
        if Toy:   #play
            State = "Playing"
        else:               #bored is default state
            State = "Bored"
        

    Nutrition = Nutrition - 3 #get hungry every turn
    if Nutrition < 0:
        Nutrition = 0
####################update State animations#############

    if oldState <> State: #state has changed, reset index counter for animation
        i = 0

    if State == "Bored":
        Tamagochi = pygame.image.load(BoredImages[i])
        i = i + 1
        i = i % 13
        StateMessage = "Derp is bored...."


    if State == "Hungry":
        Tamagochi = pygame.image.load(HungryImages[i])
        i = i + 1
        i = i % 11
        StateMessage = "Derp is starving!"


    if State == "Playing":
        Tamagochi = pygame.image.load(PlayingImages[i])
        i = i + 1
        i = i % 10
        StateMessage = "awww.....such a happy Derp!"


    if State == "Eating":
        Tamagochi = pygame.image.load(EatingImages[i])
        i = i + 1
        i = i % 11
        StateMessage = "Derp is getting fat :("


    #Reaction Message
    # Create a font
    font = pygame.font.Font(None, 30)
    Statetext = font.render(StateMessage, True, (0,0,0), (255, 255, 255))

    # Create a text box
    StatetextRect = text.get_rect()

    # Center the rectangle
    StatetextRect.centerx = 175
    StatetextRect.centery = 150
   
    screen.fill( (255, 255, 255))   #white out the screen
    screen.blit(Tamagochi, (Tamagochipos_x, Tamagochipos_y))  #draw character
    screen.blit(text, textRect)     #show text
    screen.blit(Statetext, StatetextRect)   #show State text

    if Toy:
        screen.blit(ToyImage, (500, 75))
    if Food > 0:
        screen.blit(FoodImage, (475, 275))

    pygame.display.flip()           #show character

    clock.tick(2)      #1 frames per second


pygame.quit ()
