import sys
import pandas as pd

input_arg = sys.argv[1]
df = pd.read_csv("spotify_dataset.csv")

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


if input_arg == "NameMatch":
	si = ["Harder, Better, Faster, Stronger", "Daft Punk"]
	NameMatch(si)
