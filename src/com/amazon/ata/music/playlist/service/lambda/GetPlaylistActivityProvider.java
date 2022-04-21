package com.amazon.ata.music.playlist.service.lambda;

import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.GetPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.GetPlaylistResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetPlaylistActivityProvider implements RequestHandler<GetPlaylistRequest, GetPlaylistResult> {

//    private static App app;

    public GetPlaylistActivityProvider() {

    }

    @Override
    public GetPlaylistResult handleRequest(final GetPlaylistRequest getPlaylistRequest, Context context) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return dagger.provideGetPlaylistActivity().handleRequest(getPlaylistRequest, context);
//        return getAppGetPlaylistActivityDagger().provideGetPlaylistActivity().handleRequest(getPlaylistRequest, context);
    }

//    private DaggerServiceComponent getAppGetPlaylistActivityDagger() {
//        if (this.daggerServiceComponent == null)
//            DaggerServiceComponent.create();
//        return daggerServiceComponent;
//    }
}
