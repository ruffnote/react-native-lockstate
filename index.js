import const NativeEventEmitter = require('NativeEventEmitter');

import { NativeModules, NativeEventEmitter } from 'react-native';

const { RNLockState } = NativeModules;

class LockState extends NativeEventEmitter
{
  _eventHandlers: Object;

  constructor() {
    super(RNLockState);

    this._eventHandlers = {
      change: new Map(),
    };
  }

  addEventListener(
    type: string,
    handler: Function
  ) {
    if (type === 'change') {
      this._eventHandlers[type].set(handler, this.addListener(
        'lockStateDidChange',
        (appStateData) => {
          handler(appStateData.app_state);
        }
      ));
    }
  }
}

module.exports = new LockState();
