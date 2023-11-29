###
### CS667 Data Science with Python, Final Project, Jon Organ
###

# Spotify dataset URL: https://www.kaggle.com/datasets/andrewmvd/spotify-playlists/


import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
# Version 1.0

class music_rec:
	def __init__(self, music_file, playlist_file):
		self.df_m = pd.read_csv(music_file)
		self.df_p = pd.read_csv(playlist_file)


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
		print("-----------------------------------")
		print("Input song name:", song_info['name'])
		print("Input song artist(s):", song_info['artists'])
		print("-----------------------------------")
		print("Output recommendation song name:", closest['name'].values[0])
		print("Output recommendation song artist(s):", closest['artists'].values[0])
		return closest

	def SongRec2(self, song_info):
		artists_raw = song_info['artists']
		artists = artists_raw[1:-1].split(",")

		artists[0] = artists[0][1:-1]
		i = 1
		while i < len(artists):
			artists[i] = artists[i][2:-1]
			i += 1

		for artist in artists:
			if artist in self.df_p['artistname'].values:
				print(artist, "in file")
				if song_info['name'] in self.df_p['trackname'][self.df_p['artistname'] == artist].values:
					temp_df = self.df_p[(self.df_p['artistname'] == artist) & (self.df_p['trackname'] == song_info['name'])]
					#print(temp_df[['trackname', 'artistname', 'playlistname']])

					union_df = self.df_p[self.df_p['playlistname'].isin(temp_df['playlistname'].values)]
					print(union_df)
					# TODO: Take all of the other playlists, make a union list of all songs on all of them
					# and count how often they appear, recommend the one that appears the most
					# TODO: maybe combine this with the first one
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