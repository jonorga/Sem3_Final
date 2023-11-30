###
### CS667 Data Science with Python, Final Project, Jon Organ
###

# Spotify dataset URL: https://www.kaggle.com/datasets/andrewmvd/spotify-playlists/


import pandas as pd
pd.options.mode.chained_assignment = None  # default='warn'
# Version 2.0

class music_rec:
	def __init__(self, music_file, playlist_file):
		self.df_m = pd.read_csv(music_file)
		self.df_p = pd.read_csv(playlist_file)

	def MakeRec(self, in_track, in_artist, out_track, out_artist):
		parsed_in_art = ""
		for a in in_artist:
			parsed_in_art += a
			parsed_in_art += ", "
		parsed_in_art = parsed_in_art[:-2]

		print("Input song ==================================")
		print("Song name:", in_track)
		print("Artist(s):", parsed_in_art)
		print("Output song ==================================")
		print("Song name:", out_track)
		print("Artist(s):", out_artist)


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
				if song_info['name'] in self.df_p['trackname'][self.df_p['artistname'] == artist].values:
					temp_df = self.df_p[(self.df_p['artistname'] == artist) & (self.df_p['trackname'] == song_info['name'])]

					union_df = self.df_p[self.df_p['playlistname'].isin(temp_df['playlistname'].values)]
					union_df['full_title'] = union_df['trackname'] + "     " + union_df['artistname']
					reclist = union_df['full_title'].value_counts()
					out_info = reclist.axes[0][0].split("     ")
					self.MakeRec(song_info['name'], artists, out_info[0], out_info[1])
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