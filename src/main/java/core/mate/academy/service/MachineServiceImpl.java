package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    private final BulldozerProducer bulldozerProducer = new BulldozerProducer();
    private final ExcavatorProducer excavatorProducer = new ExcavatorProducer();
    private final TruckProducer truckProducer = new TruckProducer();

    @Override
    public List<T> getAll(Class<? extends T> type) {
        List<T> machines = new ArrayList<>();

        if (type == Bulldozer.class) {
            machines.addAll((List<T>)this.bulldozerProducer.get());
        } else if (type == Excavator.class) {
            machines.addAll((List<T>)this.excavatorProducer.get());
        } else if (type == Truck.class) {
            machines.addAll((List<T>)this.truckProducer.get());
        }

        return machines;
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        Collections.fill(machines, value);
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine e: machines) {
            e.doWork();
        }
    }
}
