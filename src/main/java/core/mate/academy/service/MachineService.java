package core.mate.academy.service;

import core.mate.academy.model.Machine;
import java.util.List;

public interface MachineService<T extends Machine> {
    List<Machine> getAll(Class<? extends Machine> type);

    void fill(List<? super T> machines, T value);

    void startWorking(List<? extends Machine> machines);
}
