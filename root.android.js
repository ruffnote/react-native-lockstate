import { DeviceEventEmitter } from 'react-native';

class LockState {
  constructor() {

    this.currentState = 'unknown';

    DeviceEventEmitter.addListener('locked',() => {
      this.currentState = 'locked'
    });
    DeviceEventEmitter.addListener('unlock', () => {
      this.currentState = 'unlock'
    })
  }
}

module.exports = new LockState();
