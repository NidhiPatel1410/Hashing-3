// In this problem using a hashmap to store the songs to genre mapping, then iterating through the userSongs map
// and creating another hashmap which stores the genre and its count for a single user. Then from this map, we
// iterate and find max. Then again iterate and whatever is max, add that genre in the result list of that user.

// Time Complexity : O(mn+kl) if m-avg size of userSongs map, n- avg length of each list in usersongs map, 
// k-avg length of genreSongs map, l-avg length of each list in genre songs map
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class FavGenres {
    private HashMap<String, List<String>> findGenres(HashMap<String, List<String>> userSongs,
            HashMap<String, List<String>> genreSongs) {
        // Declare two maps, one is for result, and other has songs to genre mapping for
        // quick access
        HashMap<String, List<String>> result = new HashMap<>();
        HashMap<String, String> songsGenres = new HashMap<>();
        // Loop over the genreSongs map and create songGenres app
        for (String key : genreSongs.keySet()) {
            // Get the list of songs associated with current genre
            List<String> songs = genreSongs.get(key);
            // Iterate over that list and one by one put pair of song and genre in
            // songGenres map
            for (String song : songs) {
                songsGenres.put(song, key);
            }
        }
        // Now Loop over the user->songsList map
        for (String key : userSongs.keySet()) {
            // Get the list of songs for current user
            List<String> songs = userSongs.get(key);
            // Declare the map for the current user in which we will store the genre and
            // it's count
            HashMap<String, Integer> map = new HashMap<>();
            // Declare max
            int max = 0;
            // Loop over the list of songs that user listen, and from the songsGenre map,
            // get it's genre, and put this genre and it's count in map
            for (String song : songs) {
                map.put(songsGenres.get(song), map.getOrDefault(songsGenres.get(song), 0) + 1);
            }
            // Now loop over this genre count map, and get the max value in max
            for (String genre : map.keySet()) {
                // System.out.println(genre+map.get(genre));
                max = Math.max(max, map.get(genre));
            }
            // Now loop over the genre->count map again and get the genre name with max
            // count and put that is result
            for (String sKey : map.keySet()) {
                if (map.get(sKey) == max) {
                    if (!result.containsKey(key)) {
                        result.put(key, new ArrayList<>());
                    }
                    result.get(key).add(sKey);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();
        HashMap<String, List<String>> genreSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList(new String[] { "Song1", "Song2", "Song3", "Song4", "Song8" }));
        userSongs.put("Emma", Arrays.asList(new String[] { "Song5", "Song6", "Song7" }));
        genreSongs.put("Rock", Arrays.asList(new String[] { "Song1", "Song3" }));
        genreSongs.put("Dubstep", Arrays.asList(new String[] { "Song7" }));
        genreSongs.put("Techno", Arrays.asList(new String[] { "Song2", "Song4" }));
        genreSongs.put("Pop", Arrays.asList(new String[] { "Song5", "Song6" }));
        genreSongs.put("Jazz", Arrays.asList(new String[] { "Song8", "Song9" }));
        FavGenres m = new FavGenres();
        System.out.println(m.findGenres(userSongs, genreSongs));
    }
}