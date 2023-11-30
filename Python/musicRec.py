###
### CS667 Data Science with Python, Final Project, Jon Organ
###

# Spotify dataset URL: https://www.kaggle.com/datasets/andrewmvd/spotify-playlists/


import pandas as pd
import math
pd.options.mode.chained_assignment = None  # default='warn'
# Version 2.0

class music_rec:
	def __init__(self, music_file, playlist_file):
		self.df_m = pd.read_csv(music_file)
		self.df_p = pd.read_csv(playlist_file)

	def MakeRec(self, in_track, in_artist, out_track, out_artist, rec_type):
		parsed_in_art = ""
		for a in in_artist:
			parsed_in_art += a
			parsed_in_art += ", "
		parsed_in_art = parsed_in_art[:-2]

		print("Recommendation system:", rec_type)
		print("Input song ==================================")
		print("Song name:", in_track)
		print("Artist(s):", parsed_in_art)
		print("Output song ==================================")
		print("Song name:", out_track)
		print("Artist(s):", out_artist)
		print()


	def SongRec(self, song_info):
		temp_df = self.df_m.drop(song_info.name)
		closest = temp_df.iloc[( (temp_df["valence"]-song_info["valence"]) + 
			(temp_df["acousticness"]-song_info["acousticness"]) +
			(temp_df["energy"]-song_info["energy"]) +
			(temp_df["instrumentalness"]-song_info["instrumentalness"]) +
			(temp_df["liveness"]-song_info["liveness"]) +
			(temp_df["popularity"]-song_info["popularity"]) +
			(temp_df["speechiness"]-song_info["speechiness"]) +
			(temp_df["tempo"]-song_info["tempo"]) +
			(temp_df["danceability"]-song_info["danceability"])
			).abs().argsort()[:1]]
		self.MakeRec(song_info['name'], [song_info['artists'][2:-2]], closest['name'].values[0], 
			closest['artists'].values[0], "Music Info")
		return
		print("-----------------------------------")
		print("Input song name:", song_info['name'])
		print("Input song artist(s):", song_info['artists'])
		print("-----------------------------------")
		print("Output recommendation song name:", closest['name'].values[0])
		print("Output recommendation song artist(s):", closest['artists'].values[0])
		return closest


	def CalculateDistance(self, song1, song2):
		distance = ((song1["valence"].iloc[0] - song2["valence"]) ** 2) 
		distance += ((song1["acousticness"].iloc[0] - song2["acousticness"]) ** 2)
		distance += ((song1["energy"].iloc[0] - song2["energy"]) ** 2)
		distance += ((song1["instrumentalness"].iloc[0] - song2["instrumentalness"]) ** 2)
		distance += ((song1["liveness"].iloc[0] - song2["liveness"]) ** 2)
		distance += ((song1["popularity"].iloc[0] - song2["popularity"]) ** 2)
		distance += ((song1["speechiness"].iloc[0] - song2["speechiness"]) ** 2)
		distance += ((song1["tempo"].iloc[0] - song2["tempo"]) ** 2)
		distance += ((song1["danceability"].iloc[0] - song2["danceability"]) ** 2)
		return math.sqrt(distance)


	def PlaylistRefine(self, options, song_info):
		output_list = []
		for option in options.axes[0]:
			name, artist = option.split("     ")
			if name in self.df_m['name'].values and name != song_info['name']:
				temp_df = self.df_m[(self.df_m['name'] == name) & (self.df_m['artists'].str.contains(artist))]
				if len(temp_df.index) != 0:
					output_list.append([name, artist, round(self.CalculateDistance(temp_df, song_info), 2)])

		temp_df = pd.DataFrame(output_list, columns=['name', 'artist', 'error']).sort_values('error')
		self.MakeRec(song_info['name'], [song_info['artists'][2:-2]], temp_df['name'].iloc[0], 
			temp_df['artist'].iloc[0], "Refined Playlist")


	def PlaylistRec(self, song_info):
		artists_raw = song_info['artists']
		artists = artists_raw[1:-1].split(",")

		artists[0] = artists[0][1:-1]
		i = 1
		while i < len(artists):
			artists[i] = artists[i][2:-1]
			i += 1

		for artist in artists:
			if artist in self.df_p['artistname'].values:
				if song_info['name'] in self.df_p['trackname'][self.df_p['artistname'] == artist].values:
					temp_df = self.df_p[(self.df_p['artistname'] == artist) & (self.df_p['trackname'] == song_info['name'])]

					union_df = self.df_p[self.df_p['playlistname'].isin(temp_df['playlistname'].values)]
					union_df['full_title'] = union_df['trackname'] + "     " + union_df['artistname']
					reclist = union_df['full_title'].value_counts()
					out_info = reclist.axes[0][0].split("     ")
					self.PlaylistRefine(reclist.iloc[0:10], song_info)
					self.MakeRec(song_info['name'], artists, out_info[0], out_info[1], "Playlist")
				else:
					print("song not found")
			else:
				print(artist, "not found")




# Recommendation based off a single song
# Recommendation based off listening history

# Classifiers - Observations (valence, year, acousticness, danceability, duration_ms, energy, explicit,
# instrumentalness, key, liveness, loudness, mode, popularity, speechiness, tempo), Prediction (Good, Bad)
# name, artists
	# kNN (based off single or user history)
		# kNN with all features
		# kNN without duration_ms, explicit, key, and mode
		# kNN with all features and varying weights on features
		# Anti-kNN, users can also mention songs they don't like to avoid that type of rec
	# Logistic regression (user history only)
	# Centroid (user history only)