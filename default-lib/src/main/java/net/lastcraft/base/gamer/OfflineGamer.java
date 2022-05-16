package net.lastcraft.base.gamer;

import com.google.common.collect.ImmutableSet;
import net.lastcraft.base.gamer.sections.NetworkingSection;
import net.lastcraft.base.gamer.sections.Section;

import java.util.Set;

public final class OfflineGamer extends IBaseGamerImpl {

    private static final ImmutableSet<Class<? extends Section>> LOADED_SECTIONS = ImmutableSet.of(
            NetworkingSection.class
    );

    OfflineGamer(String name) {
        super(name);

        getSections().values().forEach(Section::loadData);
    }

    @Override
    protected Set<Class<? extends Section>> initSections() {
        return LOADED_SECTIONS;
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public void remove() {
        GamerAPI.removeOfflinePlayer(name);
    }

    @Override
    public boolean isDeveloper() {
        return false;
    }

    @Override
    public boolean isTester() {
        return false;
    }

    @Override
    public boolean isAdmin(){
        return false;
    }

    @Override
    public String toString() {
        return "OfflineGamer{name=" + this.getName() + '}';
    }
}
