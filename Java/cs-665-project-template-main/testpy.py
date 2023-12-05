import sys, os
import pandas as pd
import numpy as np
pd.options.mode.chained_assignment = None  # default='warn'

input_arg = sys.argv[1]

def NameMatch(song_info):
	df = pd.read_csv("spotify_dataset.csv")
	artist = song_info[1]
	name = song_info[0]

	if artist in df['artistname'].values:
		if name in df['trackname'][df['artistname'] == artist].values:
			temp_df = df[(df['artistname'] == artist) & (df['trackname'] == name)]
			union_name = artist + name
			temp_df.to_csv("rec_nm" + union_name + ".csv")
			print("NameMatchSucess")


def PlaylistAgg(song_info):
	artist = song_info[1]
	name = song_info[0]
	union_name = artist + name

	temp_df = pd.read_csv("rec_nm" + union_name + ".csv")
	df = pd.read_csv("spotify_dataset.csv")
	union_df = df[df['playlistname'].isin(temp_df['playlistname'].values)]
	union_df['full_title'] = union_df['trackname'] + "     " + union_df['artistname']
	union_df.to_csv("rec_pa" + union_name + ".csv")
	#os.remove("rec_nm" + union_name + ".csv")
	print("PlaylistAggSuccess")


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


if input_arg == "NameMatch":
	si = ["Harder, Better, Faster, Stronger", "Daft Punk"]
	NameMatch(si)
elif input_arg == "PlaylistAgg":
	si = ["Harder, Better, Faster, Stronger", "Daft Punk"]
	PlaylistAgg(si)
elif input_arg == "Count":
	si = ["Harder, Better, Faster, Stronger", "Daft Punk"]
	Count(si)