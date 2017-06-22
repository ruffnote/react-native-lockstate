
# react-native-lockstate

## Getting started

`$ npm install react-native-lockstate --save`

### Mostly automatic installation

`$ react-native link react-native-lockstate`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-lockstate` and add `RNLockState.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNLockState.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

Not supported yet.

## Usage
```javascript
import RNLockState from 'react-native-lockstate';

// locked / unlocked
RNLockState.addEventListener('change', (lockStateData) => {
  console.log(lockStateData);
});

// only lockComplete
RNLockState.addEventListener('lockComplete', (lockStateData) => {
  console.log(lockStateData);
});

```
  
