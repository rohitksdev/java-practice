package com.rohitksdev.designpatterns.structural.facade.smarthome;

class SmartHomeFacade {
    private SmartLightsSystem lights;
    private Thermostat thermostat;
    private SecuritySystem security;

    public SmartHomeFacade(SmartLightsSystem lights, Thermostat thermostat, SecuritySystem security) {
        // TODO: Store references to all subsystems
        this.lights = lights;
        this.thermostat = thermostat;
        this.security = security;
    }

    public void leaveHome() {
        System.out.println("--- Leaving Home ---");
        lights.off();
        thermostat.setMode("eco");
        thermostat.setTemperature(18);
        security.arm();
        System.out.println("--- Home secured ---");
    }

    public void arriveHome() {
        System.out.println("--- Arriving Home ---");
        lights.on();
        thermostat.setMode("comfort");
        thermostat.setTemperature(22);
        security.disarm();
        System.out.println("--- Welcome home! ---");
    }
}
