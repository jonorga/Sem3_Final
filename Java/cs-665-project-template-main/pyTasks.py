### *****
### Name: Jon Organ
### Course: CS-665 Software Designs & Patterns
### Date: 11/23/2023
### File Name: PlaylistAggTask.java
### Description: This file contains the PlaylistAggTask class. This class extends the Task class. It includes
### a constructor method which calls the super method. It also overrides the ProcessResults method as 
### required.
### *****

import sys, os
import pandas as pd
import numpy as np
pd.options.mode.chained_assignment = None  # default='warn'

# Parse out the input song from the command line arguments
input_arg = sys.argv[1]
song_name = ""
song_start = False
artist_name = ""
artist_start = False
for args in sys.argv:
	if args == "Song":
		song_start = True
	elif song_start and args != "Artist":
		song_name += args + " "
	if args == "Artist":
		song_start = False
		artist_start = True
	elif artist_start:
		artist_name += args + " "
song_name = song_name[:-1]
artist_name = artist_name[:-1]
si = [song_name, artist_name]


### *****
### This function performs the NameMatch task. This finds all of the playlists that the input song is on 
### from the dataset and makes a CSV file of the playlists the song was found on.
### *****
def NameMatch(song_info):
	df = pd.read_csv("spotify_dataset.csv")
	artist = song_info[1]
	name = song_info[0]

	if artist in df['artistname'].values:
		if name in df['trackname'][df['artistname'] == artist].values:
			temp_df = df[(df['artistname'] == artist) & (df['trackname'] == name)]
			union_name = artist + name
			temp_df.to_csv("rec_nm" + union_name + ".csv")
			print("NameMatchSuccess")


### *****
### This function performs the PlaylistAgg task. This finds takes the CSV file generated from the 
### NameMatch task and finds all the songs on those playlists and makes a new CSV file with these songs.
### It also deletes the CSV file generated from the NameMatch task.
### *****
def PlaylistAgg(song_info):
	artist = song_info[1]
	name = song_info[0]
	union_name = artist + name

	temp_df = pd.read_csv("rec_nm" + union_name + ".csv")
	df = pd.read_csv("spotify_dataset.csv")
	union_df = df[df['playlistname'].isin(temp_df['playlistname'].values)]
	union_df['full_title'] = union_df['trackname'] + "     " + union_df['artistname']
	union_df.to_csv("rec_pa" + union_name + ".csv")

	#print(os.path.exists("rec_nm" + union_name + ".csv"))
	os.remove("rec_nm" + union_name + ".csv")
	print("PlaylistAggSuccess")


### *****
### This function performs the Count task. This finds takes the CSV file generated from the 
### PlaylistAgg task and counts the number of occurrences of each song and makes a new file with only
### the unique occurrences and how often they occur. It also deletes the CSV file generated from the 
### PlaylistAgg task.
### *****
def Count(song_info):
	artist = song_info[1]
	name = song_info[0]
	union_name = artist + name
	union_df = pd.read_csv("rec_pa" + union_name + ".csv")
	reclist = union_df['full_title'].value_counts()
	
	data = []
	i = 0
	while i < len(reclist.values):
		data.append([reclist.axes[0][i], reclist.iloc[i]])
		i += 1

	reclist_df = pd.DataFrame(data, columns=['name', 'count'])
	reclist_df.to_csv("rec_c" + union_name + ".csv", header=True)
	os.remove("rec_pa" + union_name + ".csv")
	print("CountSuccess")


### *****
### This function performs the ReturnRec task. This finds takes the CSV file generated from the 
### Count task and returns the one with the highest count. It also deletes the CSV file generated from 
### the Count task.
### *****
def ReturnRec(song_info):
	artist = song_info[1]
	name = song_info[0]
	union_name = artist + name
	count_df = pd.read_csv("rec_c" + union_name + ".csv")
	os.remove("rec_c" + union_name + ".csv")
	rec = count_df['name'].iloc[0].split("     ")
	print("Song:", rec[0])
	print("Artist:", rec[1])
	print("ReturnRecSuccess")


if input_arg == "NameMatch":
	NameMatch(si)
elif input_arg == "PlaylistAgg":
	PlaylistAgg(si)
elif input_arg == "Count":
	Count(si)
elif input_arg == "ReturnRec":
	ReturnRec(si)



