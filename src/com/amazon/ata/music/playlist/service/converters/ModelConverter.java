package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */

    public PlaylistModel toPlaylistModel(Playlist playlist) {
        List<String> tags = null;
        if(playlist.getTags() != null) {
            tags = new ArrayList<>(playlist.getTags());
        }
//        Integer songCount = 0;
//        if (playlist.getSongCount() != 0) {
//            songCount = playlist.getSongCount();
//        }

        return PlaylistModel.builder()
            .withId(playlist.getId())
                .withName(playlist.getName())
                .withCustomerId(playlist.getCustomerId())
                .withSongCount(playlist.getSongCount())
                .withTags(tags)
            .build();
    }
    //implemented for MT4:

    /**
     * Converst a provided (@link AlbumTrack) into a (@link SongModel) representation.
     * @param albumTrack the albumTrack to convert
     * @return the converted albumTrack
     */
    public SongModel toSongModel(AlbumTrack albumTrack) {
        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withTrackNumber(albumTrack.getTrackNumber())
                .withTitle(albumTrack.getSongTitle())
                .withAlbum(albumTrack.getAlbumName())
                .build();
    }
}
